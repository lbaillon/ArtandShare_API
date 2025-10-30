package com.artandshare.api.artists.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artandshare.api.artists.model.Artist;
import com.artandshare.api.artists.service.ArtistService;

@RestController
public class ArtistController {

  @Autowired
  private ArtistService artistService;
  
  @GetMapping("/artists")
  public Iterable<Artist> getArtistes(){
    return artistService.getArtists();
  }

  @GetMapping("/artists/{id}")
  public Artist getArtiste(@PathVariable("id")final long id){
    Optional<Artist> artist = artistService.getArtist(id);

    if(artist.isPresent()) {
      return artist.get();
    }else{
      return null;
    }
  }

  @PostMapping("/artists")
  public Artist creatArtiste(@RequestBody Artist artist){
    return artistService.saveArtist(artist);
  }

  @DeleteMapping("/artists/{id}")
  public void deleteArtiste(@PathVariable("id")final long id){
    artistService.deleteArtist(id);
  }

}
