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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "actor")
public class Actor {

	@Id
	@GeneratedValue(generator = "actor_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "actor_id_seq", sequenceName = "actor_id_seq")
	private Long id;

	@ManyToMany(mappedBy = "actors")
	@JsonIgnore
	private List<Movie> movies;

	@OneToMany(mappedBy = "actor", fetch = FetchType.EAGER)
	private List<Award> awards;

	@Column(length = 75, nullable = false)
	private String firstName;

	@Column(length = 75, nullable = true)
	private String lastName;

	@Column(nullable = true)
	private Long activeSinceYear;

	@Column(nullable = true)
	@JsonFormat(timezone = "EST")
	private Date birthDate;

	public Actor() {

	}

	public Actor(String firstName, String lastName, Long activeSinceYear, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeSinceYear = activeSinceYear;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getActiveSinceYear() {
		return activeSinceYear;
	}

	public void setActiveSinceYear(Long activeSinceYear) {
		this.activeSinceYear = activeSinceYear;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

}
