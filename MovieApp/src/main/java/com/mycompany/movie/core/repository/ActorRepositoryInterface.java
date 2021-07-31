package com.mycompany.movie.core.repository;

import com.mycompany.movie.core.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepositoryInterface extends CrudRepository<Actor, Long> {}
