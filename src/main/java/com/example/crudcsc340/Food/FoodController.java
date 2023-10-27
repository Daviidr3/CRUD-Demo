package com.example.crudcsc340.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *

 @author David Vasquez
 */
@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/all")
    public String getAllFoods(Model model) {
        model.addAttribute("foodList",
                foodService.getAllFoods());
        return "Food/list-food";
    }

    @GetMapping("/search")
    public String getFoods(Model model, @Param("keyword") String keyword) {
        model.addAttribute("foodList",
                foodService.getAllFoods(keyword));
        model.addAttribute("keyword", keyword);
        return "Food/list-food";
    }

    @GetMapping("/id={foodId}")
    public String getFood(@PathVariable long foodId, Model model) {
        model.addAttribute("food",
                foodService.getFood(foodId));
        return "Foods/detail-food";
    }

    @GetMapping("/delete/id={foodId}")
    public String deleteFood(@PathVariable long foodId, Model model) {
        foodService.deleteFood(foodId);
        return "redirect:/food/all";
    }

    @PostMapping("/create")
    public String createFood(Food food) {

        foodService.saveFood(food);
        return "redirect:/food/all";
    }

    @PostMapping("/update")
    public String editFood(Food food) {
        foodService.saveFood(food);
        return "redirect:/food/all";
    }

    @GetMapping("/new-food")
    public String newFoodForm(Model model) {
        return "Foods/new-food";
    }

    @GetMapping("/update/id={foodId}")
    public String updateFoodForm(@PathVariable long foodId, Model model) {
        model.addAttribute("food",
                foodService.getFood(foodId));
        return "Food/edit-food";
    }
}
