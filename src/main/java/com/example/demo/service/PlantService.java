package com.example.demo.service;

import com.example.demo.entity.Garden;
import com.example.demo.entity.Plant;
import com.example.demo.repo.GardenRepo;
import com.example.demo.repo.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    @Autowired
    private PlantRepo plantRepo;

    @Autowired
    private GardenRepo gardenRepo;

    public List<Plant> getAll() {
        return plantRepo.findAll();
    }

    public Optional<Plant> getById(Long id) {
        return plantRepo.findById(id);
    }

    public Plant create(Plant plant, Long gardenId) {
        Optional<Garden> gardenOptional = gardenRepo.findById(gardenId);
        Garden garden = gardenOptional.get();
        plant.setGarden(garden);
        return plantRepo.save(plant);
    }

    public Plant updateGarden(Long id, Plant plantDetails) {
        return plantRepo.findById(id)
                .map(plant -> {
                    plant.setName(plantDetails.getName());
                    plant.setType(plantDetails.getType());
                    plant.setGarden(plantDetails.getGarden());
                    plant.setPlatDate(plantDetails.getPlatDate());
                    return plantRepo.save(plant);
                })
                .orElseGet(() -> {
                    plantDetails.setId(id);
                    return plantRepo.save(plantDetails);
                });
    }

    public void delete(Long id) {
        plantRepo.deleteById(id);
    }

    public List<Plant> getAllByNameSorted() {
        return plantRepo.byName();
    }

    public List<Plant> getAllByDate() {
        return plantRepo.byDate();
    }
}
