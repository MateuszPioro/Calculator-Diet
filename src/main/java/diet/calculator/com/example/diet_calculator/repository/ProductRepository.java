package diet.calculator.com.example.diet_calculator.repository;

 import diet.calculator.com.example.diet_calculator.module.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {



}
