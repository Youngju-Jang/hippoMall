package hello.spring.global.paging;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Page {
     private int currentBlock; // 1부터임
     private int currentPage;
     private int totalPage;
     private int startPage;
     private int endPage;
     private int pageScale;
}
