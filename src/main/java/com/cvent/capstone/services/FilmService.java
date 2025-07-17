package com.cvent.capstone.services;

import com.cvent.capstone.entities.Film;
import com.cvent.capstone.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public Film findById(Long id) {
        return filmRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film not found"));
    }

    public Film updateFilm(Long id, Film updatedFilm){
        Film existingFilm = this.findById(id);

        existingFilm.setTitle(updatedFilm.getTitle());
        existingFilm.setHomepage(updatedFilm.getHomepage());
        existingFilm.setOverview(updatedFilm.getOverview());
        existingFilm.setPosterPath(updatedFilm.getPosterPath());
        existingFilm.setRuntime(updatedFilm.getRuntime());
        existingFilm.setTagline(updatedFilm.getTagline());
        existingFilm.setPopularity(updatedFilm.getPopularity());
        existingFilm.setImdbId(updatedFilm.getImdbId());
        existingFilm.setVoteAverage(updatedFilm.getVoteAverage());
        existingFilm.setVoteCount(updatedFilm.getVoteCount());

        return filmRepository.save(existingFilm);
    }

    public void delete(Film film) {
        filmRepository.delete(film);
    }
}
