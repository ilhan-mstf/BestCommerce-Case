package tr.com.softtech.bestcommerce.listproducts.search;

import org.springframework.data.jpa.domain.Specification;
import tr.com.softtech.bestcommerce.listproducts.entities.Product;

public class ProductSpecification {

    public static Specification<Product> userEqualTo(Long userId) {
        return (root, query, cb) ->
            cb.equal(root.get("userId"), userId);
    }

    public static Specification<Product> inventoryGreaterThan(int num) {
        return (root, query, cb) ->
                cb.greaterThan(root.get("inventory"), num);
    }
}