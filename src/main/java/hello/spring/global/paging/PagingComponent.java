package hello.spring.global.paging;

public class PagingComponent {
     int pageScale = 3;//보여줄 row
     int blockScale = 3;//  block count
     int currentPage = 1;
     int totalRow = 0;
     public Page pagingCreate(int totalRow, int currentPage) {
          this.totalRow = totalRow;
          int totalPage = totalRow % pageScale == 0 ? (totalRow / pageScale) : (totalRow / pageScale) + 1;
          totalPage = totalPage == 0 ? 1 : totalPage;
          this.currentPage = currentPage;

          int currentBlock = currentPage % blockScale == 0 ? (currentPage / blockScale) : (currentPage / blockScale) + 1;
          int startPage = 1 + (currentBlock - 1) * blockScale;
          int endPage = currentBlock * blockScale;
          if (endPage > totalPage) endPage = totalPage;
          
          return new Page(currentBlock, currentPage, totalPage, startPage, endPage, pageScale);
     }
}