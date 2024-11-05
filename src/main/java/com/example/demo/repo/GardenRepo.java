package com.example.demo.repo;

import com.example.demo.entity.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepo extends JpaRepository<Garden, Long> {}