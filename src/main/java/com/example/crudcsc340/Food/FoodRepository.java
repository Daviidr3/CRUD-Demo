package com.example.crudcsc340.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    public List<Food> findByName(String name);

    @Query("SELECT f FROM Food f WHERE CONCAT(f.name, f.cookTime) LIKE %?1%")
    public List<Food> search(String keyword);
}
