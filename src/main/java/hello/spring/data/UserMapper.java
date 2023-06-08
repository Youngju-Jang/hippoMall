package hello.spring.data;

import hello.spring.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
     @Select("SELECT EXISTS(Select 1 from users where name = #{name} )")
     boolean isExist(String name);
     
     @Select("select user_id, name, password from users where name = #{name}")
     User selectByName(String name);
     
     @Insert("insert into users(name, password) values (#{name}, #{password})")
     void signupByUser(User user);
}
