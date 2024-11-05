package com.example.demo.controller;

import com.example.demo.entity.Garden;
import com.example.demo.service.GardenService;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gardens")
public class GardenController {

    @Autowired
    private GardenService gardenService;

    // Get all users
    @GetMapping("")
    public List<Garden> getAll() {
        return gardenService.getAll();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Garden> getUserById(@PathVariable Long id) {
        return gardenService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping
    public Garden createUser(@RequestBody Garden user) {
        return gardenService.create(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<Garden> updateUser(@PathVariable Long id, @RequestBody Garden userDetails) {
        return ResponseEntity.ok(gardenService.updateGarden(id, userDetails));
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        gardenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
