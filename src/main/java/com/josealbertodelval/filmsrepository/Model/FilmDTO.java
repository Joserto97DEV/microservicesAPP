package com.josealbertodelval.filmsrepository.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private String title;    // Título de la película (requerido)
    private int year;       // Año de lanzamiento (requerido)
    private String director; // Nombre del director (requerido)
    private Float rating;    // Calificación de la película (opcional)
}
