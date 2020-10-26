package diet.calculator.com.example.diet_calculator.module.product;

import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    //nie ujolem tutaj dto
    //patrz na zdjecie
    // service nie moze polegac tylko na tym
    private final ProductRepository productRepository;

    public void addNewProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void getOne(Long productId) {
        productRepository.getOne(productId);
    }

    public void updateProduct(Long productId, ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public List<ProductEntity> findAllProduct() {
        return productRepository.findAll();
    }

    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
}
