package com.company.reccoll.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service// marking this class as a component.
public class ServiceLayer {
    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;
    private TrackRepository trackRepository;

    @Autowired
    public ServiceLayer(AlbumRepository albumRepository,
                        ArtistRepository artistRepository,
                        LabelRepository labelRepository,
                        TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
        this.trackRepository = trackRepository;
    }
    //this will only work if tha albumViewModel has an artist and a label
    @Transactional //if this method failed anywhere, no result will be saved
    // all or nothing SUPER IMPORTANT!!!
    public AlbumViewModel saveAlbum( AlbumViewModel viewModel) {
        //write album information to the database
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setArtistId(viewModel.getArtist().getId());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setLabelId(viewModel.getLabel().getId());
        a.setListPrice(viewModel.getListPrice());

        a = albumRepository.save(a);

        //get the album id and set the album id field to each track
        Set<Track> tracks = viewModel.getTracks();

        for (Track track : tracks) {
            track.setAlbumId(a.getId());
            trackRepository.save(track);
        }

        //write each track to the database

        //get the list of track back out of the database because now they have full album information
        tracks = new HashSet<>(trackRepository.findByAlbumId(a.getId()));
        //reassemble my view model to return
        viewModel.setId(a.getId());
        viewModel.setTracks(tracks);

        return viewModel;

    }

    public AlbumViewModel findAlbum(int id) {
        AlbumViewModel returnVal = null;

        Optional<Album> album = albumRepository.findById(id);

        if(album.isPresent()) {
            //create a view model using the information from the album

            returnVal = buildAlbumViewModel(album.get());
        }

        return returnVal;
    }

    private AlbumViewModel buildAlbumViewModel(Album album) {
        AlbumViewModel returnVal = new AlbumViewModel();
        returnVal.setTitle(album.getTitle());
        Optional<Artist> artist = artistRepository.findById(album.getArtistId());
        if(artist.isPresent()) {
            returnVal.setArtist(artist.get());
        }

        Optional<Label> label = labelRepository.findById(album.getId());
        if(label.isPresent()) {
            returnVal.setLabel(label.get());
        }

        returnVal.setReleaseDate(album.getReleaseDate());
        returnVal.setListPrice(album.getListPrice());
        returnVal.setId(album.getId());
        Set<Track> trackSet = new HashSet<Track> (trackRepository.findByAlbumId(album.getId()));
        returnVal.setTracks(trackSet);
        return returnVal;
    }

    public List<AlbumViewModel> getAllAlbums() {
        List<AlbumViewModel> returnVal = new ArrayList<>();
        List<Album> allAlbums = albumRepository.findAll();

        for(Album album: allAlbums) {
            returnVal.add(buildAlbumViewModel(album));
        }
        return returnVal;
    }
    @Transactional
    public void updateAlbum(AlbumViewModel albumViewModel) {
        Album album = new Album();
        album.setId(albumViewModel.getId());
        album.setArtistId(albumViewModel.getArtist().getId());
        album.setLabelId(albumViewModel.getLabel().getId());
        album.setListPrice(albumViewModel.getListPrice());
        album.setReleaseDate(albumViewModel.getReleaseDate());

        albumRepository.save(album);
        List<Track> trackList = trackRepository.findByAlbumId(album.getId());
        trackList.stream().forEach(t -> {
            trackRepository.deleteById(t.getId());
        });

        albumViewModel.getTracks().stream()
                .forEach(t-> {
                    t.setAlbumId(album.getId());
                    trackRepository.save(t);
                });

    }

    @Transactional
    public void removeAlbum(int id) {
        AlbumViewModel album = findAlbum(id);
        List<Track> trackList = new ArrayList<>(album.getTracks());
        for(Track track: trackList){
            trackRepository.deleteById(track.getId());
        }
        albumRepository.deleteById(id);
    }
}
