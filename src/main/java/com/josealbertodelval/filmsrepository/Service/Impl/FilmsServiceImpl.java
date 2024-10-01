package com.josealbertodelval.filmsrepository.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josealbertodelval.filmsrepository.Model.FilmDTO;
import com.josealbertodelval.filmsrepository.Service.FilmsService;

@Service
public class FilmsServiceImpl implements FilmsService{

    @Override
    public ResponseEntity<?> createFilm(FilmDTO film) {
        return ResponseEntity.ok(film);
    }

    @Override
    public List<FilmDTO> searchFilms(String title, Integer year, String director) {
        var toReturn = new FilmDTO();
        if(title!=null){
            toReturn.setTitle(title);
        }
        else{
            toReturn.setTitle("El señor de los anillos");
        }
        if(year!=null){
            toReturn.setYear(year);
        }
        else{
            toReturn.setYear(2002);
        }
        if (director!=null) {
            toReturn.setDirector(director);
        }
        else{
            toReturn.setDirector("Director bueno");
        }
        toReturn.setRating(8.8f);

        List<FilmDTO> returnList = new ArrayList<>();
        returnList.add(toReturn);
        return returnList;
    }

    @Override
    public ResponseEntity<?> deleteFilm(Long id) {
        return ResponseEntity.noContent().build();
    }
    
}
