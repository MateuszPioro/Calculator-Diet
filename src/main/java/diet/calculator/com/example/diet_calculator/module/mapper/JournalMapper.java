package diet.calculator.com.example.diet_calculator.module.mapper;

import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalDto;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.JournalEntryEntity;

public class JournalMapper {

    public static JournalEntryEntity mapToEntity(JournalDto journalDto) {
        JournalEntryEntity journalEntity = new JournalEntryEntity();
        journalEntity.setProduct(ProductMapper.maptoEntity(journalDto.getProduct()));
        journalEntity.setWeight(journalDto.getWeight());
        return journalEntity;
    }


    public static JournalDto mapToDto(JournalEntryEntity journalEntryEntity) {
        JournalDto journalDto = new JournalDto();
        journalDto.setWeight(journalEntryEntity.getWeight());
        journalDto.setProduct(ProductMapper.maptoDTO(journalEntryEntity.getProduct()));
        return journalDto;
    }
}
