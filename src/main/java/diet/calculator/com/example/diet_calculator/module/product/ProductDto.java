package diet.calculator.com.example.diet_calculator.module.product;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class ProductDto {

    private String name;
    private double proteinAmount;
    private double farAmount;
    private double carbAmount;


}
