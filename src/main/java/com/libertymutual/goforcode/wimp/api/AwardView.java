package com.libertymutual.goforcode.wimp.api;

import com.libertymutual.goforcode.wimp.models.Award;

public class AwardView {

	private Award award;

	public AwardView(Award award) {
		this.award = award;
	}

	public Long getId() {
		return award.getId();
	}

	public String getTitle() {
		return award.getTitle();
	}

	public String getOrganization() {
		return award.getOrganization();
	}

	public int getYear() {
		return award.getYear();
	}

}
