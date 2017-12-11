package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.services.ActorRepository;

public class ActorsApiControllerTests {

	private ActorsApiController controller;

	@Mock
	private ActorRepository actorRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new ActorsApiController(actorRepo);
	}

	@Test
	public void getAll() {

	}

	@Test
	public void create_saves_the_actor_and_returns_it() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.save(actor)).thenReturn(actor);

		// Act
		Actor actual = controller.create(actor);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(actorRepo).save(actor);
	}

	@Test
	public void getOne_with_valid_id_returns_single_actor() {
		// Arrange
		Actor actor = new Actor();
		ActorView av = new ActorView(actor);
		when(actorRepo.findOne(1L)).thenReturn(actor);

		// Act
		ActorView actual = controller.getOne(1L);

		// Assert
		assertThat(av).isSameAs(actual);
		verify(actorRepo).save(actor);
	}

	@Test
	public void getOne_with_an_invalid_id_returns_an_actor() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void update_sets_id_of_actor_calls_save_and_returns_actor() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.save(actor)).thenReturn(actor);

		// Act
		Actor actual = controller.update(actor, 1L);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(actorRepo).save(actor);
		assertThat(actor.getId().equals(1L));
	}

	@Test
	public void delete_finds_actor_by_id_deletes_it_from_repo_and_returns_actor() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.findOne(1L)).thenReturn(actor);

		// Act
		Actor actual = controller.delete(1L);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(actorRepo).findOne(1L);
		verify(actorRepo).delete(1L);
	}
}
