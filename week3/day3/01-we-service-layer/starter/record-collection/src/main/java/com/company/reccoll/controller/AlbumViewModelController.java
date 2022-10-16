package com.company.reccoll.controller;

import com.company.reccoll.service.ServiceLayer;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/completeAlbum")
public class AlbumViewModelController {
    @Autowired
    private ServiceLayer serviceLayer;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public AlbumViewModel addANewViewModel(@RequestBody AlbumViewModel albumViewModel){
        return serviceLayer.saveAlbum(albumViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AlbumViewModel lookUpAlbumById(@PathVariable int id) {
        return serviceLayer.findAlbum(id);
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<AlbumViewModel> getAllAlbums() {
        return serviceLayer.getAllAlbums();
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updateAnAlbum(@RequestBody AlbumViewModel albumViewModel, @PathVariable int id){
        if(albumViewModel.getId() != id) {
            System.out.println("caller has provided different ids in path and body");
        }
        albumViewModel.setId(id);
        serviceLayer.updateAlbum(albumViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAnAlbumById(@PathVariable int id) {
        serviceLayer.removeAlbum(id);
    }

}
