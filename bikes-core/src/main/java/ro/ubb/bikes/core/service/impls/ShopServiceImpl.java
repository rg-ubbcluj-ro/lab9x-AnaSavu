package ro.ubb.bikes.core.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.bikes.core.model.Bike;
import ro.ubb.bikes.core.model.Shop;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;
import ro.ubb.bikes.core.model.validators.ShopValidator;
import ro.ubb.bikes.core.repository.ShopJpaRepository;
import ro.ubb.bikes.core.service.interfaces.ShopService;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    public static final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private ShopJpaRepository shopJpaRepository;

    @Autowired
    private ShopValidator shopValidator;

    @Override
    public Shop add(Shop entity) throws ValidatorException {
        log.trace("add - method entered: shop={}", entity);

        shopValidator.validate(entity);
        Shop savedShop = shopJpaRepository.save(entity);

        log.trace("add - method finished: shop={}", savedShop);
        return savedShop;
    }

    @Override
    public Shop delete(Long id) throws ValidatorException {
        log.trace("delete - method entered: id={}", id);

        Optional<Shop> optionalShop = shopJpaRepository.findById(id);
        optionalShop.ifPresentOrElse(
                (shop) -> {
                    shopJpaRepository.deleteById(shop.getId());
                    log.debug("delete - deleted: shop={}", shop);
                },
                () -> {
                    throw new ValidatorException("DELETE - Shop ID not in database");
                }
        );

        log.trace("delete - method finished");
        return optionalShop.get();
    }

    @Override
    @Transactional
    public Shop update(Shop entity) throws ValidatorException {
        log.trace("update - method entered: shop={}", entity);
        shopValidator.validate(entity);

        Shop currentShop = shopJpaRepository.findById(entity.getId()).orElseThrow(() -> new ValidatorException("UPDATE - Shop not in database"));
        log.trace("update - before update: shop={}", currentShop);

        currentShop.setName(entity.getName());
        currentShop.setCity(entity.getCity());
        log.debug("update - updated: shop={}", currentShop);

        log.trace("update - method finished");
        return entity;
    }

    @Override
    public List<Shop> getAll() {
        log.trace("getAll --- method entered");
        List<Shop> shops = shopJpaRepository.findAll();
        log.trace("getAll: result={}", shops);
        return shops;
    }

    @Override
    public Shop exist(Long id) throws ValidatorException {
        log.trace("exist - method entered: id={}", id);
        Shop shop = shopJpaRepository.findById(id).orElseThrow(() -> new ValidatorException("EXIST - Shop ID not in database"));
        log.trace("exist - method finished: shop found={}", shop);
        return shop;
    }

    @Override
    public List<Shop> filter(String name) {
        log.trace("filter - method entered: name={}", name);
        List<Shop> shops = shopJpaRepository.findByName(name);
        log.trace("filter: result={}", shops);
        return shops;
    }

    @Override
    public List<Shop> sort() {
        log.trace("sort - method entered");
        List<Shop> shops = shopJpaRepository.findByOrderByCity();
        log.trace("sort: result={}", shops);
        return shops;
    }
}
