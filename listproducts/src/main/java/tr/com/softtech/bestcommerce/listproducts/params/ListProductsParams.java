package tr.com.softtech.bestcommerce.listproducts.params;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListProductsParams {

    private Long userId;
    private int page;
    private int size;
    private String[] sort;
}
