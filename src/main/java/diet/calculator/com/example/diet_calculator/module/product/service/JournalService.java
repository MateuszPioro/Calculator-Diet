package diet.calculator.com.example.diet_calculator.module.product.service;


import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import diet.calculator.com.example.diet_calculator.repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalService {


    private final ProductService productService;
private final JournalRepository journalRepository;

    public List<ProductDto> findAllListProducts(){
        return productService.getProducts();
    }

    public void delete(Long productId) {
        journalRepository.deleteById(productId);
    }

}
