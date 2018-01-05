package com.libertymutual.goforcode.wimp.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.wimp.models.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {

	List<Award> findByActorId(Long id);

}
