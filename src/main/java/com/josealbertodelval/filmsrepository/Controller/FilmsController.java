package com.josealbertodelval.filmsrepository.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josealbertodelval.filmsrepository.Model.FilmDTO;
import com.josealbertodelval.filmsrepository.Service.FilmsService;

@RestController
@RequestMapping("/films")
public class FilmsController {
    
    @Autowired
    FilmsService filmsService;

    @PostMapping("/create")
	public ResponseEntity<?> createFilm(@RequestBody FilmDTO film) {
        return filmsService.createFilm(film);
	}

    @PutMapping("/update")
	public ResponseEntity<?> updateFilm(@RequestBody FilmDTO film) {
        return filmsService.createFilm(film);
	}

    @GetMapping("/find")
	public ResponseEntity<List<FilmDTO>> searchFilms(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String director) {
        
        List<FilmDTO> films = filmsService.searchFilms(title, year, director);
        return ResponseEntity.ok(films);
    }

    @DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFilm(@PathVariable("id") Long id) {
        return filmsService.deleteFilm(id);
	}
}
