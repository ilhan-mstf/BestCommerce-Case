package tr.com.softtech.bestcommerce.listproducts.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.softtech.bestcommerce.listproducts.entities.Product;
import tr.com.softtech.bestcommerce.listproducts.services.ListProductsService;

import java.util.List;

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
    public List<Product> listProducts() {
        return listProductsService.listProducts();
    }

}
