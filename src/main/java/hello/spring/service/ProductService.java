package hello.spring.service;

import hello.spring.data.ProductRepository;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Product;
import hello.spring.global.paging.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
     private final ProductRepository productRepository;
     private final String downImagePath = "/Users/joj1043/Documents/bit/DJ_3mon_subModules/hipponMall/src/main/resources/downImage";
     public List<ProductResponseDto> selectAll(HashMap<String, Object> hashMap) {
          List<Product> productList = productRepository.selectAll(hashMap);
          if (productList == null) {
               return null;
          }
          return productList.stream().map(ProductResponseDto::entity2Dto).collect(Collectors.toList());
     }
     
     public int countAll(String search, String option) {
          HashMap<String, String> map = new HashMap<>();
          map.put("search", search);
          map.put("option", option);
          return productRepository.countAll(map);
     }
}
