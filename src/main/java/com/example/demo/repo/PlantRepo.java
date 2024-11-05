package com.example.demo.repo;

import com.example.demo.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantRepo extends JpaRepository<Plant,Long> {

    @Query(value = "select p from Plant p ORDER BY p.name")
    List<Plant> byName();

    @Query(value = "select p from Plant p order by p.platDate")
    List<Plant> byDate();
}
