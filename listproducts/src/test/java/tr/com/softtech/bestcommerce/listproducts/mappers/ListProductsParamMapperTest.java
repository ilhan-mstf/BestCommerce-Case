package tr.com.softtech.bestcommerce.listproducts.mappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.softtech.bestcommerce.listproducts.params.ListProductsParams;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ListProductsParamMapperTest {

    @Autowired
    private ListProductsParamMapper listProductsParamMapper;

    @Test
    public void whenValidParams_ThenShouldReturnPageable() {
        ListProductsParams params = new ListProductsParams(
                1L,1,1, new String[] {"id", "desc"});

        Pageable pageable = listProductsParamMapper.paramsToPageable(params);

        assertThat(pageable).isNotNull();
        assertThat(pageable.getPageSize()).isEqualTo(params.getSize());
    }
}
