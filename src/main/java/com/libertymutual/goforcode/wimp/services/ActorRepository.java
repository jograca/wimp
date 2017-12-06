package com.libertymutual.goforcode.wimp.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.wimp.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	List<Actor> findByLastNameIgnoringCase(String lastName);

	List<Actor> findByActiveSinceYearLessThanEqual(Long activeSinceYear);

}
