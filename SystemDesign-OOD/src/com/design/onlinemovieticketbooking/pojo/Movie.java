package com.design.onlinemovieticketbooking.pojo;

import java.util.Date;
import java.util.List;

import com.design.onlinemovieticketbooking.entity.Admin;

public class Movie {
	private String title;
	private String description;
	private int durationInMins;
	private String language;
	private Date releaseDate;
	private String country;
	private String genre;
	private Admin movieAddedBy;

	private List<Show> shows;

	public List<Show> getShows(){
		return shows;
		
	}
}