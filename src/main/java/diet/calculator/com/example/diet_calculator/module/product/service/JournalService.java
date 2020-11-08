package diet.calculator.com.example.diet_calculator.module.product.service;


import diet.calculator.com.example.diet_calculator.module.product.model.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.model.ProductEntity;
import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalService {


    private final ProductService productService;


    public List<ProductDto> findAllListProducts(){
        return productService.getProducts();
    }

}
