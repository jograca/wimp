package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.MovieRepository;

public class StarsApiControllerTests {

	private StarsApiController controller;

	@Mock
	private ActorRepository actorRepo;

	@Mock
	private MovieRepository movieRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new StarsApiController(actorRepo, movieRepo);
	}

	@Test
	public void getOne_with_a_valid_id_returns_a_single_actor() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.findOne(1L)).thenReturn(actor);

		// Act
		Actor actual = controller.getOne(1L);

		// Assert
		assertThat(actor).isSameAs(actual);
		verify(actorRepo).findOne(1L);

	}

	@Test
	public void getOne_with_an_invalid_id_returns_a_single_award() {
		// Arrange
		when(actorRepo.findOne(1L)).thenReturn(null);

		// Act
		Actor actual = controller.getOne(1L);

		// Assert
		assertThat(actual).isNull();
		verify(actorRepo).findOne(1L);

	}

	@Test
	public void create_associates_a_movie_with_an_actor_when_it_is_not_already_listed() {
		// Arrange
		Movie movie = new Movie();
		// Set a blank Array of Movies
		movie.setActors(new ArrayList<Actor>());
		Actor actor = new Actor();
		when(actorRepo.findOne(1L)).thenReturn(actor);
		when(movieRepo.findOne(2L)).thenReturn(movie);

		// Act
		Movie actual = controller.create(2L, 1L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
		assertThat(movie.getActors()).contains(actor);
		verify(actorRepo).findOne(1L);
		verify(movieRepo).findOne(2L);

	}

	@Test
	public void create_does_not_associate_a_movie_with_an_actor_if_they_are_already_in_it() {
		// Arrange
		Actor actor = new Actor();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(actor);
		Movie movie = new Movie();
		movie.setActors(actors);

		when(movieRepo.findOne(1L)).thenReturn(movie);
		when(actorRepo.findOne(1L)).thenReturn(actor);

		// Act
		Movie actual = controller.create(1L, 1L);

		// Assert
		verify(movieRepo).findOne(1L);
		verify(actorRepo).findOne(1L);
		assertThat(actual).isSameAs(movie);
		assertThat(movie.getActors().contains(actor));
		verify(movieRepo, never()).save(movie);
		assertThat(movie.getActors()).hasSize(1);
	}

}
