package diet.calculator.com.example.diet_calculator.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private double proteinAmount;
    private double fatAmount;
    private double carbAmount;

//    @Enumerated(EnumType.ORDINAL)
//    private Macronutrients macronutrients;

    public double calculateCalories() {
        return proteinAmount * Macronutrients.PROTEIN.getCalories() + fatAmount * Macronutrients.FAT.getCalories() + 0;
    }



}
