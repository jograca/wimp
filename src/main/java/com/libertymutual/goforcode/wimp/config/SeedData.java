package com.libertymutual.goforcode.wimp.config;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo) {

		Actor jb = actorRepo.save(new Actor("Jack", "Black", (long) 1982, new Date(1969, 8, 28)));
		Actor mjc = actorRepo.save(new Actor("John", "Cusack", (long) 1983, new Date(1966, 6, 28)));
		Actor czj = actorRepo.save(new Actor("Catherine", "Zeta-Jones", (long) 1995, new Date(1990, 9, 25)));
		Actor ih = actorRepo.save(new Actor("Iben", "Hjejle", (long) 1992, new Date(1971, 3, 22)));
		Actor fjc = actorRepo.save(new Actor("Joan", "Cusack", (long) 1979, new Date(1962, 10, 11)));

		Movie hf = movieRepo.save(new Movie("High Fidelity", new Date(2000, 3, 31), (long) 30000000, "Touchstone"));
		Movie cu = movieRepo.save(new Movie("Coyote Ugly", new Date(2000, 8, 4), (long) 45000000, "Touchstone"));
		Movie mm = movieRepo.save(new Movie("The Muppet Movie", new Date(1979, 6, 22), null, "ITC Films"));

		ArrayList<Actor> actors = new ArrayList<Actor>();

		actors.add(mjc);
		actors.add(fjc);
		hf.setActors(actors);

		actorRepo.save(mjc);

		ArrayList<Movie> movies = new ArrayList<Movie>();

		movies.add(hf);
		mjc.setMovies(movies);

		movieRepo.save(hf);

	}
}
