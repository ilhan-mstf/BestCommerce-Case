package tr.com.softtech.bestcommerce.listproducts.mappers;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.softtech.bestcommerce.listproducts.dtos.ProductDto;
import tr.com.softtech.bestcommerce.listproducts.entities.Product;
import tr.com.softtech.bestcommerce.listproducts.enums.DeliveryOptions;
import tr.com.softtech.bestcommerce.listproducts.enums.PaymentOptions;
import tr.com.softtech.bestcommerce.listproducts.enums.ProductCategory;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void whenNonNullProduct_thenShouldReturnPoductDto() {
        Product product = new Product();
        product.setName("name");
        product.setDeliveryOptions(DeliveryOptions.FAST_DELIVERY);
        product.setDescription("desc");
        product.setId(1L);
        product.setInventory(1);
        product.setPaymentOptions(PaymentOptions.DIRECT);
        product.setPrice(1);
        product.setProductCategory(ProductCategory.ELECTRONICS);
        product.setUserId(1L);

        ProductDto productDto = productMapper.entityToDto(product);

        assertThat(productDto.getDeliveryOptions()).isEqualTo(product.getDeliveryOptions());
        assertThat(productDto.getDescription()).isEqualTo(product.getDescription());
        assertThat(productDto.getId()).isEqualTo(product.getId());
        assertThat(productDto.getInventory()).isEqualTo(product.getInventory());
        assertThat(productDto.getName()).isEqualTo(product.getName());
        assertThat(productDto.getPaymentOptions()).isEqualTo(product.getPaymentOptions());
        assertThat(productDto.getProductCategory()).isEqualTo(product.getProductCategory());
        assertThat(productDto.getPrice()).isEqualTo(product.getPrice());

        assertThat(productDto).isNotEqualTo(product);
    }

    @Test
    public void whenNullProduct_thenShouldReturnNull() {
        ProductDto productDto = productMapper.entityToDto(null);

        assertThat(productDto).isNull();
    }

}
