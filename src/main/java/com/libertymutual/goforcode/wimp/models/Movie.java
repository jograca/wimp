package com.libertymutual.goforcode.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(generator = "movie_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_id_seq", sequenceName = "movie_id_seq")
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Actor> actors;

	@Column(length = 300, nullable = false)
	private String title;

	@Column(nullable = true)
	@JsonFormat(timezone = "EST")
	private Date releaseDate;

	@Column(nullable = true)
	private Long budget;

	@Column(length = 500, nullable = false)
	private String distributor;

	public Movie() {

	}

	public Movie(String title, Date releaseDate, Long budget, String distributor) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.distributor = distributor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}
