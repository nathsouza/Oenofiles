package com.nathalie.oenofiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathalie.oenofiles.models.Wine;
import com.nathalie.oenofiles.repositories.WineRepository;

@Service
public class WineService {
	@Autowired
	private WineRepository wineRepo;
	
	public List<Wine> allWines(){
		return wineRepo.findAll();
	}
	
	//find one
	public Wine findone(Long id) {
		Optional<Wine> wine = wineRepo.findById(id);
		if(wine.isPresent()) {
			return wine.get();
		}else {
			return null;
		}
	}
	
	//wine by id
	public Wine wineById(Long id) {
		if(wineRepo.findById(id) != null) {
			return wineRepo.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	
	//create wine
	public Wine newWine(Wine wine) {
		return wineRepo.save(wine);
	}
	
	//update wine
	public Wine updateWine(Wine wine) {
		
		return wineRepo.save(wine);
	}
	
	//delete a wine
	public void deleteWine(Long id) {
		wineRepo.deleteById(id);
	}
	
	

}

