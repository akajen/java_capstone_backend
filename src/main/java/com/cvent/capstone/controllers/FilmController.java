package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.Film;
import com.cvent.capstone.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public List<Film> getFilms() {
        return filmService.findAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.findById(id);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        if(film.getTitle() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Film title cannot be null");
        }
        return filmService.save(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film updatedFilm) {
        if(updatedFilm.getTitle() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Film title cannot be null");
        }
        Film result = filmService.updateFilm(id, updatedFilm);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        Film existingFilm = filmService.findById(id);
        filmService.delete(existingFilm);
        return ResponseEntity.noContent().build();
    }
}
