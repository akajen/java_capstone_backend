package com.cvent.capstone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "TITLE")
    private String title;

    @Column(name = "HOMEPAGE")
    private String homepage;

    @Column(name = "OVERVIEW")
    private String overview;

    @Column(name = "POSTER_PATH")
    private String posterPath;

    @Column(name = "RUNTIME")
    private Long runtime;

    @Column(name = "TAGLINE")
    private String tagline;

    @Column(name = "POPULARITY")
    private Double popularity;

    @Column(name = "IMDBID")
    private String imdbId;

    @Column(name = "VOTE_AVERAGE")
    private Double voteAverage;

    @Column(name = "VOTE_COUNT")
    private Long voteCount;
}
