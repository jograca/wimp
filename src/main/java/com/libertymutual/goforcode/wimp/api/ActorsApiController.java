package com.libertymutual.goforcode.wimp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.services.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorsApiController {

	private ActorRepository actorRepo;

	public ActorsApiController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Actor> getAll(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) Long activeSinceYear) {
		if (firstName != null) {
			return actorRepo.findByFirstNameIgnoringCase(firstName);
		}
		if (lastName != null) {
			return actorRepo.findByLastNameIgnoringCase(lastName);
		}
		if (activeSinceYear != null) {
			return actorRepo.findByActiveSinceYearLessThanEqual(activeSinceYear);
		}

		return actorRepo.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Actor getActor(@PathVariable Long id) {
		return actorRepo.findOne(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Actor delete(@PathVariable Long id) {
		Actor actor = actorRepo.findOne(id);
		actorRepo.delete(actor);
		return actor;
	}
}
