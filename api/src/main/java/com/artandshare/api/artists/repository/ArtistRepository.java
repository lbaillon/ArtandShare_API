package com.artandshare.api.artists.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artandshare.api.artists.model.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long>{

  
} 
