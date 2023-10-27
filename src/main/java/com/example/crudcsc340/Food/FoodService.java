package com.example.crudcsc340.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author David Vasquez
 */
@Service
public class FoodService {

    @Autowired
    private FoodRepository repo;

    /**
     * Get all food.
     *
     * @return the list of foods.
     */
    public List<Food> getAllFoods() {
        return repo.findAll();
    }

    /**
     * Get all food that match the keyword.
     *
     * @param keyword the search term.
     * @return the list of foods.
     */
    public List<Food> getAllFoods(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Get a single food plate by ID.
     *
     * @param foodId
     * @return the food.
     */
    public Food getFood(long foodId) {
        return repo.getReferenceById(foodId);
    }

    /**
     * Delete a single food plate by ID.
     *
     * @param foodId
     */
    public void deleteFood(long foodId) {
        repo.deleteById(foodId);
    }

    /**
     * Save a Food plate entry.
     *
     * @param food
     */
    void saveFood(Food food) {
        repo.save(food);
    }

}