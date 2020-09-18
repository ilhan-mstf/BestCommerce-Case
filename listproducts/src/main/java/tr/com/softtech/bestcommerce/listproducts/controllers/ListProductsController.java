package tr.com.softtech.bestcommerce.listproducts.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.com.softtech.bestcommerce.listproducts.dtos.ProductDto;
import tr.com.softtech.bestcommerce.listproducts.params.ListProductsParams;
import tr.com.softtech.bestcommerce.listproducts.services.ListProductsService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping(ListProductsController.ENDPOINT)
@Api(produces = MediaType.APPLICATION_JSON_VALUE, tags = "List products")
public class ListProductsController {

    public static final String ENDPOINT = "/v1/products";

    @Autowired
    private ListProductsService listProductsService;

    @CrossOrigin
    @ApiOperation("List products")
    @GetMapping
    public List<ProductDto> listProducts(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {
        ListProductsParams params = new ListProductsParams(userId, page, size, sort);
        return listProductsService.listProducts(params);
    }

}
