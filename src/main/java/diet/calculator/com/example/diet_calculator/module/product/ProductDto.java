package diet.calculator.com.example.diet_calculator.module.product;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private double proteinAmount;
    private double fatAmount;
    private double carbAmount;


    public double calculateCalories() {
        return proteinAmount * Macronutrients.PROTEIN.getCalories() +
                fatAmount * Macronutrients.FAT.getCalories() + carbAmount * Macronutrients.CARBOHYDRATES.getCalories();
    }

}
