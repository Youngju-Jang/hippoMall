package hello.spring.data;

import hello.spring.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductRepository {
     @Select("select count(1) " +
          "from product " +
          "<if test=\"hashMap.search != null and hashMap.search != ''\">" +
          "where ${option} like CONCAT('%',#{search},'%')" +
          "</if>")
     int countAll(HashMap<String, String> hashMap);
     
     @Select ("select * from (select @rownum:=@rownum+1 rm, PRODUCT.* from PRODUCT, (SELECT @rownum:=0) r where 1=1 "
          + "<if test=\'search != null and search != &quot;&quot;\'>"
          + "and ${option} like CONCAT('%',#{search},'%')"
          + "</if>"
          + "order by no desc) PRODUCT "
          + "where rm between ((#{pageBean.currentPage}-1)*#{pageBean.pageScale} +1) and (#{pageBean.currentPage}*#{pageBean.pageScale})")
     List<Product> selectAll(HashMap<String, Object> hashMap);
     
     void productInsert(Product product);
     Product selectById(int no);
     void updateById(HashMap<String, Object> hashMap);
     void deleteById(int no);
}
