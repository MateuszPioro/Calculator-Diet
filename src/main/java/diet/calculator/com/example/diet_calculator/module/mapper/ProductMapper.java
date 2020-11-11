package diet.calculator.com.example.diet_calculator.module.mapper;

import diet.calculator.com.example.diet_calculator.module.product.model.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.model.ProductEntity;

public class ProductMapper {


    public static ProductEntity maptoEntity(ProductDto productDto){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setCarbAmount(productDto.getCarbAmount());
        productEntity.setFatAmount(productDto.getFatAmount());
        productEntity.setProteinAmount(productDto.getProteinAmount());
        return productEntity;

    }



    public static ProductDto maptoDTO(ProductEntity productEntity){
        ProductDto productDto = new ProductDto();
        productDto.setName(productEntity.getName());
        productDto.setCarbAmount(productEntity.getCarbAmount());
        productDto.setFatAmount(productEntity.getFatAmount());
        productDto.setProteinAmount(productEntity.getProteinAmount());
        return productDto;
    }
}
