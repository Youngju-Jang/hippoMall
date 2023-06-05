package hello.spring.entity;

import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
     private int no;
     private String productName;
     private String productOrigin;
     private int productPrice;
     private Category productCategory;
     private String fileName;
     private String regdate;
     private int count;
     
     public static Set<Integer> getNoList(List<Cart> cart){
          return cart.stream().map(Cart::getNo).collect(Collectors.toSet());
     }
     
     public static Cart Product2Cart(Product product){
          return Cart.builder()
               .no(product.getNo())
               .productName(product.getProductName())
               .productOrigin(product.getProductOrigin())
               .productPrice(product.getProductPrice())
               .productCategory(product.getProductCategory())
               .fileName(product.getProductFileName())
               .regdate(product.getToday())
               .count(1)
               .build();
     }
     
     @Override
     public boolean equals(Object obj) {
          Cart cart = (Cart) obj;
          return this.no == cart.getNo();
     }
}