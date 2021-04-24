package ro.ubb.bikes.core.service.interfaces;

import ro.ubb.bikes.core.model.Shop;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.List;

public interface ShopService  extends ServiceCommon<Long, Shop>{
    @Override
    Shop add(Shop entity) throws ValidatorException;

    @Override
    Shop delete(Long id) throws ValidatorException;

    @Override
    Shop update(Shop entity) throws ValidatorException;

    @Override
    List<Shop> getAll();

    @Override
    Shop exist(Long id) throws ValidatorException;

    List<Shop> filter(String name);

    List<Shop> sort();
}
