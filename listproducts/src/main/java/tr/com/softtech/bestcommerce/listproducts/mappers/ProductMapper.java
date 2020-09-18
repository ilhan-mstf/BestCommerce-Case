package tr.com.softtech.bestcommerce.listproducts.mappers;

import org.springframework.stereotype.Component;
import tr.com.softtech.bestcommerce.listproducts.dtos.ProductDto;
import tr.com.softtech.bestcommerce.listproducts.entities.Product;

@Component
public class ProductMapper {

    public ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setInventory(product.getInventory());
        productDto.setPrice(product.getPrice());
        productDto.setDeliveryOptions(product.getDeliveryOptions());
        productDto.setPaymentOptions(product.getPaymentOptions());
        productDto.setProductCategory(product.getProductCategory());
        return productDto;
    }
}
