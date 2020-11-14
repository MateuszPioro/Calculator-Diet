package diet.calculator.com.example.diet_calculator.module.mapper;

import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalDto;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.JournalEntryEntity;

public class JournalMapper {

    public static JournalEntryEntity mapToEntity(JournalDto journalDto) {
        JournalEntryEntity journalEntity = new JournalEntryEntity();
        return journalEntity;
    }
}
