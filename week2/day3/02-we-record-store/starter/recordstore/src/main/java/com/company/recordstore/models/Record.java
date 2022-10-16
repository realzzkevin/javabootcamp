package com.company.recordstore.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Record {
    @NotEmpty(message = "you should provide a value for artist")
    private String artist;
    @NotEmpty(message = "you should provide a value for album")
    private String album;
    private int id;
    @NotEmpty()
    @Size(min = 4, max = 4, message = "year must be 4 digits")
    private String year;
    public Record() { }

    public Record(String artist, String album, int id, String year) {
        this.artist = artist;
        this.album = album;
        this.id = id;
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public Record(String artist, String album, int id) {
        this.artist = artist;
        this.album = album;
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id && artist.equals(record.artist) && album.equals(record.album) && year.equals(record.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, album, id, year);
    }

    @Override
    public String toString() {
        return "Record{" +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", id=" + id +
                ", year='" + year + '\'' +
                '}';
    }
}
