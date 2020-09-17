package tr.com.softtech.bestcommerce.listproducts.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.softtech.bestcommerce.listproducts.entities.Product;
import tr.com.softtech.bestcommerce.listproducts.repositories.ProductRepository;
import tr.com.softtech.bestcommerce.listproducts.services.ListProductsService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProductServiceImpl implements ListProductsService {

    @Override
    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        Product p = new Product();
        p.setId("1");
        p.setName("iPhone");
        products.add(p);
        return products;
    }
}
