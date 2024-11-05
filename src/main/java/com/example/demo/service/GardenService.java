package com.example.demo.service;

import com.example.demo.entity.Garden;
import com.example.demo.repo.GardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardenService {
    @Autowired
    private GardenRepo gardenRepo;

    public List<Garden> getAll() {
        return gardenRepo.findAll();
    }

    public Optional<Garden> getById(Long id) {
        return gardenRepo.findById(id);
    }

    public Garden create(Garden garden) {
        return gardenRepo.save(garden);
    }

    public Garden updateGarden(Long id, Garden gardenDetails) {
        return gardenRepo.findById(id)
                .map(garden -> {
                    garden.setName(gardenDetails.getName());
                    garden.setSize(gardenDetails.getSize());
                    return gardenRepo.save(garden);
                })
                .orElseGet(() -> {
                    gardenDetails.setId(id);
                    return gardenRepo.save(gardenDetails);
                });
    }

    public void delete(Long id) {
        gardenRepo.deleteById(id);
    }
}
