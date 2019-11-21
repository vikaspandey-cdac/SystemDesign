package com.design.onlinemovieticketbooking.services;

import java.util.Date;
import java.util.List;

import com.design.onlinemovieticketbooking.pojo.Movie;

public interface Search {
	public List<Movie> searchByTitle(String title);

	public List<Movie> searchByLanguage(String language);

	public List<Movie> searchByGenre(String genre);

	public List<Movie> searchByReleaseDate(Date relDate);

	public List<Movie> searchByCity(String cityName);
}
