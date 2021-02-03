package diet.calculator.com.example.diet_calculator.module.product.service;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Serving;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@Log4j2 // dzięki temu możemy używac loggera
public class FoodNutritionService {
    // zostanie automatycznie wstrzyknięty przez Springa
    private final ProductRepository productRepository;

    private FatsecretService fatsecretService = new FatsecretService("d746c8374aeb47eab8fff6f63cff92e7",
            "3e37b607893c47208f42dc4c4397767c");

    // te metode przeba zawolac w metodzie z @PostConstruct dla kilku roznych id - obok tego, gdzie zapisujesz banana
    // przykladowe wywolanie: downloadFoodByIdAndSaveProductToDb(39790L);
    public void downloadFoodByIdAndSaveProductToDb(Long fatSecretFoodId) {
        final Food food = fatsecretService.getFood(fatSecretFoodId);
        if (food == null) { // jeżeli nie udało się pobrac z API produktu o takim ID
            log.warn("Nie udało się znaleźć produktu o id " + fatSecretFoodId + " w FatSecret API!");
            return; // wyjdź z tej metody i nie wykonuj tego kodu, który jest dalej
        }
        final Serving serving = food.getServings().get(0);
        final BigDecimal multiplier = BigDecimal.valueOf(100.0).divide(serving.getMetricServingAmount(), RoundingMode.HALF_UP);
        final String name = food.getName();
        final double carbsPer100g = serving.getCarbohydrate().multiply(multiplier).doubleValue();
        final double proteinPer100g = serving.getProtein().multiply(multiplier).doubleValue();
        final double fatPer100g = serving.getFat().multiply(multiplier).doubleValue();

        // na podstawie wyciągniętych danych budujemy nowy ProductEntity
        final ProductEntity productEntity = new ProductEntity(null, name, proteinPer100g, fatPer100g, carbsPer100g);
        // i zapisujemy go do bazy danych
        productRepository.save(productEntity);
        log.info("Zapisałem do bazy produkt " + productEntity.getName());
    }

    /**
     * Ta metoda pozwala nam zapisać "maxResults" produktów do naszej bazy danych, wyszukując je
     * w FatSecret API za pomocą nazwy "productName"
     * @param productName nazwa szukanych produktów, np. "chicken"
     * @param maxResults maksymalna liczba wyników dla podanego hasła, jaką chcemy zapisać do bazy, np. 5
     */
    public void downloadFoodsByNameAndSaveProductToDb(String productName, int maxResults) {
        // tak pobierzemy listę około 50 produktów z podana nazwą
        final Response<CompactFood> productSearchResult = fatsecretService.searchFoods(productName);
        // niestety, elementy tak pobrane mają za mało szczegółów, żebyśmy mogli je efektywnie wykorzystać
        // natomiast możemy wykorzystać identyfikatory, które nam zwróciło to wyszukiwanie!
        int alreadySavedProducts = 0; // licznik, ile produktów dotychczas zapisaliśmy do bazy
        for (CompactFood singleSearchResult : productSearchResult.getResults()) {
            // bierzemy identyfikator znalezionego produktu i wywołujemy przygotowaną wcześniej metodę, która pobiera szczegóły
            downloadFoodByIdAndSaveProductToDb(singleSearchResult.getId());
            alreadySavedProducts++; // wlasnie zapislaiśmy kolejny produkt, więc zwiększ licznik!
            if (alreadySavedProducts >= maxResults) { // czy zapisliśmy już tyle produktów, ile mieliśmy?
                return; // jeżeli tak, to kończymy wykonanie metody
            }
        }
    }
}