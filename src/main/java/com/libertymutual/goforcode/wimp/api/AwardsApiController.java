package com.libertymutual.goforcode.wimp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "*")
public class AwardsApiController {

	private AwardRepository awardRepo;
	private ActorRepository actorRepo;

	public AwardsApiController(AwardRepository awardRepo, ActorRepository actorRepo) {
		this.awardRepo = awardRepo;
		this.actorRepo = actorRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Award> getAll() {
		return awardRepo.findAll();
	}

	@GetMapping("{id}")
	public Award getOne(@PathVariable long id) {
		return awardRepo.findOne(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@PathVariable Long actorId, @RequestBody Award award) {
		Actor actor = actorRepo.findOne(actorId);
		award.setActor(actor);
		awardRepo.save(award);
		actorRepo.save(actor);

		return actor;
	}

	@DeleteMapping("{id}")
	public Award delete(@PathVariable Long id) {
		Award award = awardRepo.findOne(id);
		awardRepo.delete(id);
		return award;
	}
}
