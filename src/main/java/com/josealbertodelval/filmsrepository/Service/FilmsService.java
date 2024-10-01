package com.josealbertodelval.filmsrepository.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.josealbertodelval.filmsrepository.Model.FilmDTO;

public interface FilmsService {

    ResponseEntity<?> createFilm(FilmDTO film);

    List<FilmDTO> searchFilms(String title, Integer year, String director);

    ResponseEntity<?> deleteFilm(Long id);
    
}
