package diet.calculator.com.example.diet_calculator.module.product.model.entity;

import diet.calculator.com.example.diet_calculator.module.product.model.Macronutrients;
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
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double proteinAmount;
    private double fatAmount;
    private double carbAmount;




}
