package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap;
    HashMap<String,Director> directorMap;
    HashMap<String, List<String>> pairMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.pairMap =new HashMap<>();
    }

    public void addMovie(Movie movie) {
       movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        if(pairMap.containsKey(director)){
            List<String> temp=pairMap.get(director);
            temp.add(movie);
            pairMap.put(director,temp);
            //OR
            //pairMap.get(director).add(movie);
        }
        else{
            List<String> temp=new ArrayList<>();
            temp.add(movie);
            pairMap.put(director,temp);
        }
    }

    public Movie getMovieByName(String moviename) {
        return movieMap.get(moviename);
    }

    public Director getDirectorByName(String directorname) {
        return directorMap.get(directorname);
    }

    public List<String> getMoviesByDirectorName(String directorname) {
        return pairMap.get(directorname);
    }

    public List<String> findAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for(String m : movieMap.keySet()){
            allMovies.add(movieMap.get(m).getName());
        }
        return allMovies;
    }

    public void deleteDirectorByName(String director) {
        List<String> movielist = pairMap.get(director);
        for(String s : movielist){
            movieMap.remove(s);
        }
        directorMap.remove(director);
        pairMap.remove(director);
    }

    public void deleteAllDirectors() {
        for(String directorName : pairMap.keySet()){
            deleteDirectorByName(directorName);
        }
    }
}
