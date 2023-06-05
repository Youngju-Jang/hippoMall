package hello.spring.data;

import hello.spring.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface CartMapper {
     List<Product> selectAllByNoSet(@Param("newCartSet") Set<Integer> newCartSet);
     
}
