package com.libertymutual.goforcode.wimp.api;

import java.util.Date;

import com.libertymutual.goforcode.wimp.models.Actor;

public class ActorView {

	private Actor actor;

	public ActorView(Actor actor) {
		this.actor = actor;
	}

	public Long getId() {
		return actor.getId();
	}

	public String getFirstName() {
		return actor.getFirstName();
	}

	public String getLastName() {
		return actor.getLastName();
	}

	public Long getActiveSinceYear() {
		return actor.getActiveSinceYear();
	}

	public Date getBirthDate() {
		return actor.getBirthDate();
	}
}
