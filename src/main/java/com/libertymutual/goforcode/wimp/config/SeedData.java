package com.libertymutual.goforcode.wimp.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.AwardRepository;
import com.libertymutual.goforcode.wimp.services.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo, AwardRepository awardRepo) {

		actorRepo.save(new Actor("Jack", "Black", (long) 1982, new Date(1421893256000L)));
		actorRepo.save(new Actor("John", "Cusack", (long) 1983, new Date(1421893256000L)));
		actorRepo.save(new Actor("Catherine", "Zeta-Jones", (long) 1995, new Date(1421893256000L)));
		actorRepo.save(new Actor("Iben", "Hjejle", (long) 1992, new Date(1421893256000L)));
		actorRepo.save(new Actor("Joan", "Cusack", (long) 1979, new Date(1421893256000L)));

		movieRepo.save(new Movie("High Fidelity", new Date(1421893256000L), (long) 30000000, "Touchstone"));
		movieRepo.save(new Movie("Coyote Ugly", new Date(1421893256000L), (long) 45000000, "Touchstone"));
		movieRepo.save(new Movie("The Muppet Movie", new Date(1421893256000L), null, "ITC Films"));

		awardRepo.save(new Award("Emmy", "The Academy", 1997));
		awardRepo.save(new Award("Golden Globe", "The Academy", 1997));

	}
}
