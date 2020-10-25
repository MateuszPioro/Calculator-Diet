package diet.calculator.com.example.diet_calculator.repository;

import diet.calculator.com.example.diet_calculator.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
