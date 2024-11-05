package com.example.demo.controller;

import com.example.demo.entity.Garden;
import com.example.demo.entity.Plant;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // Get all users
    @GetMapping("")
    public List<Plant> getAll() {
        return plantService.getAll();
    }

    @GetMapping("/byName")
    public List<Plant> getAllByName(){
        return plantService.getAllByNameSorted();
    }
    @GetMapping("/byDate")
    public List<Plant> getAllByDate(){
        return plantService.getAllByDate();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getUserById(@PathVariable Long id) {
        return plantService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping
    public Plant create(@RequestBody Plant plant, @RequestParam("garden_id") Long id) {
        return plantService.create(plant, id);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updateUser(@PathVariable Long id, @RequestBody Plant plantDetails) {
        return ResponseEntity.ok(plantService.updateGarden(id, plantDetails));
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        plantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
