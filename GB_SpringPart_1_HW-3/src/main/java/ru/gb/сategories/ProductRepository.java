package ru.gb.сategories;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product(1L,"Shorts", 39.50));
        this.insert(new Product(2L, "Surfboard", 350.00));
        this.insert(new Product(3L, "Sunscreen", 25.35));
    }

    private void insert(Product product) {
            long id = identity.incrementAndGet();
            product.setId(id);
            productMap.put(id, product);
    }

    public List<Product> findAll() {return new ArrayList<>(productMap.values());}

    public Product findById(Long id) {return productMap.get(id);}

    public void update(Product user) { productMap.put(user.getId(), user);}

    public void delete(long id) {productMap.remove(id);}

}