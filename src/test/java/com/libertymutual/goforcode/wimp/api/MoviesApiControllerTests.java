package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.MovieRepository;

public class MoviesApiControllerTests {

	private MoviesApiController controller;
	private MovieRepository movieRepo;

	@Before
	public void setup() {
		movieRepo = mock(MovieRepository.class);
		controller = new MoviesApiController(movieRepo);
	}

	@Test
	public void getAll_returns_a_list_of_movies() {
		// Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		when(movieRepo.findAll()).thenReturn(movies);

		// Act
		List<Movie> actual = controller.getAll();

		// Assert
		assertThat(movies).isSameAs(actual);
		verify(movieRepo).findAll();
	}

	@Test
	public void getOne_with_valid_id_returns_single_movie() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.findOne(1L)).thenReturn(movie);

		// Act
		Movie actual = controller.getOne(1L);

		// Assert
		assertThat(movie).isSameAs(actual);
		verify(movieRepo).findOne(1L);

	}

	@Test
	public void getOne_with_an_invalid_id_returns_a_movie() {
		// Arrange
		when(movieRepo.findOne(1L)).thenReturn(null);

		// Act
		Movie actual = controller.getOne(1L);

		// Assert
		assertThat(actual).isNull();
		verify(movieRepo).findOne(1L);
	}

	@Test
	public void create_saves_the_movie_and_returns_it() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.create(movie);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
	}

	@Test
	public void update_sets_id_of_the_movie_calls_save_and_returns_a_movie() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.update(movie, 1L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
		assertThat(movie.getId().equals(1L));
	}

	@Test
	public void delete_gets_the_movie_by_id_deletes_it_from_the_repo_and_returns_it() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.findOne(1L)).thenReturn(movie);

		// Act
		Movie actual = controller.delete(1L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).findOne(1L);
		verify(movieRepo).delete(1L);
	}
}