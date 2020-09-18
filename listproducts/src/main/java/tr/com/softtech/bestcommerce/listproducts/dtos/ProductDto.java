package tr.com.softtech.bestcommerce.listproducts.dtos;

import lombok.Data;
import tr.com.softtech.bestcommerce.listproducts.enums.DeliveryOptions;
import tr.com.softtech.bestcommerce.listproducts.enums.PaymentOptions;
import tr.com.softtech.bestcommerce.listproducts.enums.ProductCategory;

@Data
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private int inventory;

    private int price;

    private ProductCategory productCategory;

    private PaymentOptions paymentOptions;

    private DeliveryOptions deliveryOptions;
}
