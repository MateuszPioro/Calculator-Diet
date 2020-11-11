package diet.calculator.com.example.diet_calculator.repository;

 import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {



}
