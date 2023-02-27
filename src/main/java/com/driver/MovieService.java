package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String moviename) {
        Movie temp = movieRepository.getMovieByName(moviename);
        return temp;
    }

    public Director getDirectorByName(String directorname) {
        Director temp = movieRepository.getDirectorByName(directorname);
        return temp;
    }

    public List<String> getMoviesByDirectorName(String directorname) {
        List<String> temp = movieRepository.getMoviesByDirectorName(directorname);
        return temp;
    }

    public List<String> findAllMovies() {
        List<String> temp = movieRepository.findAllMovies();
        return temp;
    }

    public void deleteDirectorByName(String director) {
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
