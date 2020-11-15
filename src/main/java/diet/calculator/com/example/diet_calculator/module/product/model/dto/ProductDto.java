package diet.calculator.com.example.diet_calculator.module.product.model.dto;

import diet.calculator.com.example.diet_calculator.module.product.model.Macronutrients;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private double proteinAmount;
    private double fatAmount;
    private double carbAmount;


    public double calculateCalories() {
        return proteinAmount * Macronutrients.PROTEIN.getCalories() +
                fatAmount * Macronutrients.FAT.getCalories() + carbAmount * Macronutrients.CARBOHYDRATES.getCalories();
    }


}
