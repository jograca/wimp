package com.libertymutual.goforcode.wimp.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.wimp.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
