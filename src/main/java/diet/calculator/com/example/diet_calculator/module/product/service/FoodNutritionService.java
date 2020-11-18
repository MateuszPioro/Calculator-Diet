package diet.calculator.com.example.diet_calculator.module.product.service;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Serving;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodNutritionService {
    private FatsecretService fatsecretService = new FatsecretService("d746c8374aeb47eab8fff6f63cff92e7",
            "3e37b607893c47208f42dc4c4397767c");

    // te metode przeba zawolac w metodzie z @PostConstruct dla kilku roznych id - obok tego, gdzie zapisujesz banana
    // przykladowe wywolanie: downloadFoodByIdAndSaveProductToDb(39790L);
    public void downloadFoodByIdAndSaveProductToDb(Long fatSecretFoodId) {
        final Food food = fatsecretService.getFood(fatSecretFoodId);
        final Serving serving = food.getServings().get(0);
        final BigDecimal multiplier = BigDecimal.valueOf(100.0).divide(serving.getMetricServingAmount(), RoundingMode.HALF_UP);
        final String name = food.getName();
        final double carbsPer100g = serving.getCarbohydrate().multiply(multiplier).doubleValue();
        final double proteinPer100g = serving.getProtein().multiply(multiplier).doubleValue();
        final double fatPer100g = serving.getFat().multiply(multiplier).doubleValue();
        // TODO zbudowac na tej podstawie ProductEntity (new ProductEntity()    .setName(..)
        // TODO zapisac ProductEntity do bazy (używając ProductRepository) save

    }
}