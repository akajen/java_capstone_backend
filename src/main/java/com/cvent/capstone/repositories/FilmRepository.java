package com.cvent.capstone.repositories;

import com.cvent.capstone.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAll();

    Film save(Film film);

    Optional<Film> findById(Long id);

    void delete(Film film);
}
