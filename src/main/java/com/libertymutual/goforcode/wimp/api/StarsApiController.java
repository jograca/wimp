package com.libertymutual.goforcode.wimp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.MovieRepository;

@RestController
@RequestMapping("/api/movies/{movieId}/actors")
public class StarsApiController {

	private ActorRepository actorRepo;
	private MovieRepository movieRepo;

	public StarsApiController(ActorRepository actorRepo, MovieRepository movieRepo) {
		this.actorRepo = actorRepo;
		this.movieRepo = movieRepo;
	}

	@GetMapping("{id}")
	public Actor getOne(@PathVariable long id) {
		return actorRepo.findOne(id);
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {

		Movie movie = movieRepo.findOne(movieId);
		Actor actor = actorRepo.findOne(actorId);

		if (!movie.getActors().contains(actor)) {
			movie.getActors().add(actor);
			movieRepo.save(movie);
		}
		return movie;
	}
}
