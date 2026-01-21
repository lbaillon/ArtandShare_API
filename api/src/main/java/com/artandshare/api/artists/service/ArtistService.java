package com.artandshare.api.artists.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.artists.model.Artist;
import com.artandshare.api.artists.repository.ArtistRepository;

import lombok.Data;

//Data ajoute en auto les getters et setters
@Data
@Service
public class ArtistService {

  @Autowired
  private ArtistRepository artistRepository;

  public Iterable<Artist> getArtists(){
    return artistRepository.findAll();
  }

  public Optional<Artist> getArtist(final long id){
    return artistRepository.findById(id);
  }

  public Artist saveArtist(Artist artist){
    if(artist==null){
      throw new RuntimeException("Artist must not be null");
    }
    Artist savedArtist = artistRepository.save(artist);
    return savedArtist;
  }

  public void deleteArtist(final long id){
    artistRepository.deleteById(id);
  }

}
