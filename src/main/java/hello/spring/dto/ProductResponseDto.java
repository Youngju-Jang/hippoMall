package hello.spring.dto;

import hello.spring.entity.Category;
import hello.spring.entity.Product;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
     private int no;
     private String productName;
     private String productOrigin;
     private int productPrice;
     private Category productCategory;
     private String fileName;
     private int id;
     private String seller;
     private String regdate;
     
     public static ProductResponseDto entity2Dto(Product entity){
          return  ProductResponseDto.builder()
               .no(entity.getNo())
               .productName(entity.getProductName())
               .productOrigin(entity.getProductOrigin())
               .productPrice(entity.getProductPrice())
               .productCategory(entity.getProductCategory())
               .fileName(entity.getProductFileName())
               .id(entity.getId())
               .regdate(entity.getToday())
               .build();
     }
}
