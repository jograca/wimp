package com.libertymutual.goforcode.wimp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MoviesApiController {

	private MovieRepository movieRepo;

	public MoviesApiController(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}

	@GetMapping("{id}")
	public Movie getMovie(@PathVariable Long id) {
		return movieRepo.findOne(id);
	}

	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable Long id) {
		movie.setId(id);
		return movieRepo.save(movie);
	}

	@DeleteMapping("{id}")
	public Movie delete(@PathVariable Long id) {
		Movie movie = movieRepo.findOne(id);
		movieRepo.delete(movie);
		return null;
	}
}
