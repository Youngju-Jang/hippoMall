package hello.spring.data;

import hello.spring.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface CartRepository {
     List<Product> selectAllByNoSet(@Param("newCartSet") Set<Integer> newCartSet);
     
}
