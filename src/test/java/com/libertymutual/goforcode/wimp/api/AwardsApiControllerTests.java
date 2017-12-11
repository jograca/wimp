package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.AwardRepository;

public class AwardsApiControllerTests {

	private AwardsApiController controller;

	@Mock
	private AwardRepository awardRepo;

	@Mock
	private ActorRepository actorRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new AwardsApiController(awardRepo, actorRepo);
	}

	@Test
	public void getOne_with_a_valid_id_returns_a_single_award() {
		// Arrange
		Award award = new Award();
		when(awardRepo.findOne(1L)).thenReturn(award);

		// Act
		Award actual = controller.getOne(1L);

		// Assert
		assertThat(award).isSameAs(actual);
		verify(awardRepo).findOne(1L);
	}

	@Test
	public void getOne_with_an_invalid_id_returns_a_single_award() {
		// Arrange
		when(awardRepo.findOne(1L)).thenReturn(null);

		// Act
		Award actual = controller.getOne(1L);

		// Assert
		assertThat(actual).isNull();
		verify(awardRepo).findOne(1L);
	}

	@Test
	public void create_associates_the_award_with_an_actor_saves_the_award_and_actor_and_returns_actor() {
		// Arrange
		Award award = new Award();
		Actor actor = new Actor();
		when(actorRepo.findOne(1L)).thenReturn(actor);

		// Act
		Actor actual = controller.create(1L, award);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(awardRepo).save(award);
		verify(actorRepo).findOne(1L);
	}
}
