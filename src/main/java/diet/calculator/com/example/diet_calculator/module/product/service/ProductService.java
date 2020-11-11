package diet.calculator.com.example.diet_calculator.module.product.service;

import diet.calculator.com.example.diet_calculator.module.mapper.ProductMapper;
import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;


    public void getOne(Long productId) {
        productRepository.getOne(productId);
    }

    //zmiana dto na entity  mapToEntity, mozna zapisac w serive privte
    public void updateProduct(Long productId, ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.maptoEntity(productDto);
        productEntity.setId(productId);
        productRepository.save(productEntity);

    }

    public List<ProductDto> getProducts() {
        List<ProductEntity> allProducts = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductEntity product : allProducts) {
            ProductDto productDto = ProductMapper.maptoDTO(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }


    public void saveProductDTO(ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.maptoEntity(productDto);
        productRepository.save(productEntity);
    }

    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }




}
