package com.libertymutual.goforcode.wimp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.services.ActorRepository;
import com.libertymutual.goforcode.wimp.services.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardsApiController {

	private AwardRepository awardRepo;
	private ActorRepository actorRepo;

	public AwardsApiController(AwardRepository awardRepo, ActorRepository actorRepo) {
		this.awardRepo = awardRepo;
		this.actorRepo = actorRepo;
	}

	@GetMapping("{id}")
	public Award getOne(@PathVariable long id) {
		return awardRepo.findOne(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@PathVariable Long actorId, @RequestBody Long awardId) {

		Actor actor = actorRepo.findOne(actorId);
		Award award = awardRepo.findOne(awardId);

		award.setActor(actor);
		actorRepo.save(actor);

		return actor;
	}
}
