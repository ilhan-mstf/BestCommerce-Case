package tr.com.softtech.bestcommerce.listproducts.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tr.com.softtech.bestcommerce.listproducts.dtos.ProductDto;
import tr.com.softtech.bestcommerce.listproducts.entities.Product;
import tr.com.softtech.bestcommerce.listproducts.mappers.ListProductsParamMapper;
import tr.com.softtech.bestcommerce.listproducts.mappers.ProductMapper;
import tr.com.softtech.bestcommerce.listproducts.params.ListProductsParams;
import tr.com.softtech.bestcommerce.listproducts.repositories.ProductRepository;
import tr.com.softtech.bestcommerce.listproducts.search.ProductSpecification;
import tr.com.softtech.bestcommerce.listproducts.services.ListProductsService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListProductServiceImpl implements ListProductsService {

    @Value("${product.search.inventoryThreshold}")
    private int inventoryThreshold;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ListProductsParamMapper listProductsParamMapper;

    @Override
    public List<ProductDto> listProducts(ListProductsParams params) {
        Page<Product> products = productRepository.findAll(
                ProductSpecification.userEqualTo(params.getUserId())
                        .and(ProductSpecification.inventoryGreaterThan(inventoryThreshold)),
                listProductsParamMapper.paramsToPageable(params));
        List<ProductDto> productDtos = products
                .stream()
                .map(p -> productMapper.entityToDto(p))
                .collect(Collectors.toList());
        return productDtos;
    }
}
