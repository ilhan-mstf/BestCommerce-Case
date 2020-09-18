package tr.com.softtech.bestcommerce.listproducts.services;

import tr.com.softtech.bestcommerce.listproducts.dtos.ProductDto;
import tr.com.softtech.bestcommerce.listproducts.params.ListProductsParams;

import java.util.List;

public interface ListProductsService {

    List<ProductDto> listProducts(ListProductsParams params);
}
