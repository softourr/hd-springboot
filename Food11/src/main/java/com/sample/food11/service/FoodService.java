package com.sample.food11.service;

import com.sample.food11.api.request.CreateAndEditFoodRequest;
import com.sample.food11.model.FoodEntity;
import com.sample.food11.model.MenuEntity;
import com.sample.food11.repository.FoodRepository;
import com.sample.food11.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Transactional
    public FoodEntity createFood(
            CreateAndEditFoodRequest request
    ){
        FoodEntity food =
                FoodEntity.
                        builder().name(request.getName()).address(request.getAddress())
                        .createdAt(ZonedDateTime.now())
                        .updatedAt(ZonedDateTime.now())
                        .build();

        foodRepository.save(food);

        request.getMenus().forEach((menu)->{
            MenuEntity menuEntity =
                    MenuEntity.builder()
                            .foodId(food.getId())
                            .name(menu.getName())
                            .price(menu.getPrice())
                            .createdAt(ZonedDateTime.now())
                            .updatedAt(ZonedDateTime.now())
                            .build();
            menuRepository.save(menuEntity);
        });

        return food;
    }

    @Transactional
    public void editFood(
        Long foodId,
        CreateAndEditFoodRequest request
    ){
        FoodEntity food = foodRepository.findById(foodId).orElseThrow(()->new RuntimeException("Food not found"));
        food.changeNameAndAddress(request.getName(), request.getAddress());
        foodRepository.save(food);

        List<MenuEntity> menus = menuRepository.findAllByFoodId(foodId);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach((menu)->{
            MenuEntity menuEntity =
                    MenuEntity.builder()
                            .foodId(food.getId())
                            .name(menu.getName())
                            .price(menu.getPrice())
                            .createdAt(ZonedDateTime.now())
                            .updatedAt(ZonedDateTime.now())
                            .build();
            menuRepository.save(menuEntity);
        });


    }

    public void deleteFood(Long foodId){
        FoodEntity food = foodRepository.findById(foodId).orElseThrow(()->new RuntimeException("Food not found"));
        foodRepository.delete(food);

        List<MenuEntity> menus = menuRepository.findAllByFoodId(foodId);
        menuRepository.deleteAll(menus);



    }



}
