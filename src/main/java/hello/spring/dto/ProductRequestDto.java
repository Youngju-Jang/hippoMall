package hello.spring.dto;

import hello.spring.entity.Category;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequestDto {
     private String productName;
     private String productOrigin;
     private int productPrice;
     private Category productCategory;
     private MultipartFile file;
}
