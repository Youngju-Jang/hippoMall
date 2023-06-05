package hello.spring.entity;

import hello.spring.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
     private int no;
     private String productName;
     private String productOrigin;
     private int productPrice;
     private Category productCategory;
     private String productFileName;
     private int id;
     private String today;
     
     public Product(ProductRequestDto dto, int userId, String fileName){
          this.productName = dto.getProductName();
          this.productOrigin = dto.getProductOrigin();
          this.productPrice = dto.getProductPrice();
          this.productCategory = dto.getProductCategory();
          this.productFileName = fileName;
          this.id = userId;
     }
     
     public void updateProduct(ProductRequestDto dto) {
          this.productName = dto.getProductName();
          this.productOrigin = dto.getProductOrigin();
          this.productPrice = dto.getProductPrice();
          this.productCategory = dto.getProductCategory();
     }
}
