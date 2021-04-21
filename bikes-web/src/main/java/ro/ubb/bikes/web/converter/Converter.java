package ro.ubb.bikes.web.converter;

import ro.ubb.bikes.core.model.BaseEntity;
import ro.ubb.bikes.web.dto.BaseDto;

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}

