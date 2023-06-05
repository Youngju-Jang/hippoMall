package hello.spring.data;

import hello.spring.entity.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductMapper {
     int countAll(HashMap<String, String> hashMap);
     List<Product> selectAll(HashMap<String, Object> hashMap);
     void productInsert(Product product);
     Product selectById(int no);
     void updateById(HashMap<String, Object> hashMap);
     void deleteById(int no);
}
