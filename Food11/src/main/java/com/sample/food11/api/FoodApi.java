package com.sample.food11.api;

import com.sample.food11.api.request.CreateAndEditFoodRequest;
import com.sample.food11.model.FoodEntity;
import com.sample.food11.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodApi {
    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public String getFoods() {
        return "getFoods";
    }

    @GetMapping("/food/{foodId}")
    public String viewFood(
            @PathVariable("foodId") Long foodId
    ) {
        return "viewFood " + foodId;
    }

    @PostMapping("/food")
    public FoodEntity postFood(
            @RequestBody CreateAndEditFoodRequest request
    ){
        return foodService.createFood(request);
    }

    @PutMapping("/food/{foodId}")
    public void editFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody CreateAndEditFoodRequest request
    ) {
        foodService.editFood(foodId, request);
    }

    @DeleteMapping("/food/{foodId}")
    public void deleteFood(
            @PathVariable("foodId") Long foodId
    ) {
        foodService.deleteFood(foodId);
    }

}
