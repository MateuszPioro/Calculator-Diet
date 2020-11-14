package diet.calculator.com.example.diet_calculator.module.product.service;


import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalForm;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.JournalEntryEntity;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import diet.calculator.com.example.diet_calculator.repository.JournalRepository;
import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalService {


    private final ProductService productService;
    private final JournalRepository journalRepository;
    private final ProductRepository productRepository;

    public List<JournalEntryEntity> findAllListProducts() {
        return journalRepository.findAll();
    }

    public void delete(Long productId) {
        journalRepository.deleteById(productId);
    }


    public void addProductToJournal(JournalForm journalForm) {
        JournalEntryEntity journalEntryEntity = new JournalEntryEntity();
        journalEntryEntity.setWeight(journalForm.getWeight());
        Optional<ProductEntity> productById = productRepository.findById(journalForm.getProductId());
        journalEntryEntity.setProduct(productById.get());
        journalRepository.save(journalEntryEntity);
    }

}
