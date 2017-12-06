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
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}

	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@GetMapping("{id}")
	public Actor getActor(@PathVariable Long id) {
		return actorRepo.findOne(id);
	}

	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}

	@DeleteMapping("{id}")
	public Actor delete(@PathVariable Long id) {
		Actor actor = actorRepo.findOne(id);
		actorRepo.delete(actor);
		return actor;
	}
}
