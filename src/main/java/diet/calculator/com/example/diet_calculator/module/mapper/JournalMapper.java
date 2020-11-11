package diet.calculator.com.example.diet_calculator.module.mapper;

import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalDto;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.JournalEntity;

public class JournalMapper {

    public static JournalEntity mapToEntity(JournalDto journalDto) {
        JournalEntity journalEntity = new JournalEntity();
        return journalEntity;
    }
}
