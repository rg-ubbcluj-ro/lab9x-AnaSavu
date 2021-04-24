package ro.ubb.bikes.core.repository;

import ro.ubb.bikes.core.model.Shop;

import java.util.List;

public interface ShopJpaRepository extends IRepository<Shop, Long>{
    List<Shop> findByName(String name);
    List<Shop> findByOrderByCity();
}
