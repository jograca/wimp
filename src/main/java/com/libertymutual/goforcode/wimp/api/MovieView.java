package com.libertymutual.goforcode.wimp.api;

import java.util.Date;

import com.libertymutual.goforcode.wimp.models.Movie;

public class MovieView {

	private Movie movie;

	public MovieView(Movie movie) {
		this.movie = movie;
	}

	public Long getId() {
		return movie.getId();
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public Date getReleaseDate() {
		return movie.getReleaseDate();
	}

	public Long getBudget() {
		return movie.getBudget();
	}

	public String getDistributor() {
		return movie.getDistributor();
	}
}
