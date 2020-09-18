package tr.com.softtech.bestcommerce.listproducts.mappers;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import tr.com.softtech.bestcommerce.listproducts.params.ListProductsParams;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListProductsParamMapper {

    public Pageable paramsToPageable(ListProductsParams params) {
        return PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.by(getSortOrders(params.getSort())));
    }

    private List<Order> getSortOrders(String[] sort) {
        List<Order> orders = new ArrayList<Order>();

        for (int i = 0; i < sort.length; i += 2) {
            orders.add(new Order(getDirection(sort[i+1]), sort[i]));
        }

        return orders;
    }

    private Direction getDirection(String direction) {
        if (direction.equals("asc")) {
            return Direction.ASC;
        } else {
            return Direction.DESC;
        }
    }

}
