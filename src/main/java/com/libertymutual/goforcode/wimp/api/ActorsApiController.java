package com.libertymutual.goforcode.wimp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.services.ActorRepository;

@RestController
@RequestMapping("/api/actors")
@CrossOrigin(origins = "*")
public class ActorsApiController {

	private ActorRepository actorRepo;

	public ActorsApiController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ActorView> getAll() {
		List<Actor> actors = actorRepo.findAll();
		ArrayList<ActorView> actorViews = new ArrayList<ActorView>();

		for (Actor actor : actors) {
			actorViews.add(new ActorView(actor));
		}
		return actorViews;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ActorView getOne(@PathVariable Long id) {
		ActorView av = null;
		Actor actor = actorRepo.findOne(id);
		if (actor != null) {
			av = new ActorView(actor);
		}
		return av;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}

	@DeleteMapping("{id}")
	public Actor delete(@PathVariable Long id) {
		Actor actor = actorRepo.findOne(id);
		actorRepo.delete(id);
		return actor;
	}
}
