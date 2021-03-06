package tr.com.softtech.bestcommerce.listproducts.entities;

import lombok.Data;
import tr.com.softtech.bestcommerce.listproducts.enums.DeliveryOptions;
import tr.com.softtech.bestcommerce.listproducts.enums.PaymentOptions;
import tr.com.softtech.bestcommerce.listproducts.enums.ProductCategory;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String name;

    private String description;

    private int inventory;

    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    private ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_options")
    private PaymentOptions paymentOptions;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_options")
    private DeliveryOptions deliveryOptions;

}
