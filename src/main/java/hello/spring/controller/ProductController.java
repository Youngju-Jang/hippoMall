package hello.spring.controller;

import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.OptionEnum;
import hello.spring.global.paging.Page;
import hello.spring.global.paging.PagingComponent;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
     private final ProductService productService;
     
     @GetMapping
     public ResponseEntity<List<ProductResponseDto>> getList(@RequestParam (defaultValue = "1") int page,
                                                             @RequestParam (defaultValue = "") String search,
                                                             @RequestParam (defaultValue = "") OptionEnum option
                                                             ) {
          
          
          int totalRow = productService.countAll(search, (option==null? null : option.name())); // 제품테이블 전체로우수
          Page pageBean = getPageBean(page, totalRow);
          
          HashMap<String, Object> map = createMap(search, (option==null? null : option.name()), pageBean); // db파라미터용 map 생성
          
          return new ResponseEntity<>(productService.selectAll(map), HttpStatus.OK);
     }
     
     private static HashMap<String, Object> createMap(String search, String option, Page pageBean) {
          HashMap<String, Object> map = new HashMap<>();
          map.put("search", search);
          map.put("option", option);
          map.put("pageBean", pageBean);
          return map;
     }
     
     private static Page getPageBean(int page, int totalRow) {
          PagingComponent pagingComponent = new PagingComponent();
          return pagingComponent.pagingCreate(totalRow, page);
     }
}
