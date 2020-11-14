package diet.calculator.com.example.diet_calculator.repository;

 import diet.calculator.com.example.diet_calculator.module.product.model.entity.JournalEntryEntity;
 import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntryEntity,Long> {



}
