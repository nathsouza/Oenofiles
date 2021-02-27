package com.nathalie.oenofiles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nathalie.oenofiles.models.Wine;

@Repository
public interface WineRepository extends CrudRepository<Wine, Long> {
	List <Wine> findAll();
}
