package hello.spring.data;

import hello.spring.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
     @Select("SELECT EXISTS(Select 1 from users where name = #{name} )")
     boolean isExist(String name);
     
     @Select("select user_id, name, password from users where name = #{name}")
     Optional<User> findByUsername(String name);
     
     @Insert("insert into users(name, password, role) values (#{name}, #{password}, #{role})")
     void signupByUser(User user);
}
