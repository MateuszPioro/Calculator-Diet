package diet.calculator.com.example.diet_calculator.module;

public enum  Macronutrients {

    FAT(9),
    PROTEIN(4),
    CARBOHYDRATES(4);



   private final int valueCalorie;


     Macronutrients(int valueCalorie) {
       this.valueCalorie=valueCalorie;
    }

    public int getCalories(){
         return valueCalorie;
    }
}
