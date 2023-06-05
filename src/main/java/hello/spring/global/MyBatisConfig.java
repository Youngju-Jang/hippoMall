package hello.spring.global;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {
     
     @Value ("${mybatis.configuration.map-underscore-to-camel-case}")
     private boolean mapUnderscoreToCamelCase;
     
     @Bean
     public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
          SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
          sessionFactory.setDataSource(dataSource);
          
          org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
          configuration.setMapUnderscoreToCamelCase(mapUnderscoreToCamelCase);
          
          sessionFactory.setConfiguration(configuration);
          
          return sessionFactory;
     }
}
