package com.libertymutual.goforcode.wimp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "award")
public class Award {

	@Id
	@GeneratedValue(generator = "award_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "award_id_seq", sequenceName = "award_id_seq")
	private Long id;

	@ManyToOne
	@JsonIgnore
	private Actor actor;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(length = 200, nullable = false)
	private String organization;

	@Column
	private int year;

	public Award() {

	}

	public Award(String title, String organization, int year) {
		this.title = title;
		this.organization = organization;
		this.year = year;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
