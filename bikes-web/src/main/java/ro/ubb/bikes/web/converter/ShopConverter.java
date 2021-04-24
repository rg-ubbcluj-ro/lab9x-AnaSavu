package ro.ubb.bikes.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Shop;
import ro.ubb.bikes.web.dto.ShopDto;

@Component
public class ShopConverter extends BaseConverter<Shop, ShopDto>{
    @Override
    public Shop convertDtoToModel(ShopDto dto) {
        var model = new Shop();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setCity(dto.getCity());
        return model;
    }

    @Override
    public ShopDto convertModelToDto(Shop shop) {
        ShopDto dto = new ShopDto(shop.getName(), shop.getCity());
        dto.setId(shop.getId());
        return dto;
    }
}
