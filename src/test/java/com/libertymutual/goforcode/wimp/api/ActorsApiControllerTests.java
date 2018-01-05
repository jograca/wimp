package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.AwardRepository;

public class ActorsApiControllerTests {

	private ActorsApiController actorsController;
	private AwardsApiController awardsController;

	@Mock
	private ActorRepository actorRepo;

	@Mock
	private AwardRepository awardRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		actorsController = new ActorsApiController(actorRepo, awardRepo);
	}

	@Test
	public void getAll_returns_list_of_all_actors_in_actorview() {
		// Arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Actor actor = new Actor();

		actor.setId(1L);
		actors.add(actor);
		when(actorRepo.findAll()).thenReturn(actors);

		// Act
		ActorView actual = actorsController.getAll().get(0);

		// Assert
		assertThat(actual.getId()).isEqualTo(1L);
		verify(actorRepo).findAll();
	}

	@Test
	public void create_saves_the_actor_and_returns_it() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.save(actor)).thenReturn(actor);

		// Act
		Actor actual = actorsController.create(actor);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(actorRepo).save(actor);
	}

	@Test
	public void getOne_with_valid_id_returns_single_actor() {
		// Arrange
		Actor actor = new Actor();
		actor.setId(1L);
		when(actorRepo.findOne(1L)).thenReturn(actor);

		// Act
		ActorView actual = actorsController.getOne(1L);

		// Assert
		assertThat(actual.getId()).isEqualTo(1L);
		verify(actorRepo).findOne(1L);
	}

	@Test
	public void getOne_with_an_invalid_id_returns_an_actor() {
		// Act
		ActorView actual = actorsController.getOne(1L);

		// Assert
		assertThat(actual).isNull();
		verify(actorRepo).findOne(1L);
	}

	// @Test
	// public void update_sets_id_of_actor_calls_save_and_returns_actor() {
	// // Arrange
	// Actor actor = new Actor();
	// when(actorRepo.save(actor)).thenReturn(actor);
	//
	// // Act
	// Actor actual = actorsController.update(actor, 1L);
	//
	// // Assert
	// assertThat(actual).isSameAs(actor);
	// verify(actorRepo).save(actor);
	// assertThat(actor.getId().equals(1L));
	// }

}
