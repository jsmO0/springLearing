package com.shuming;

import lombok.Cleanup;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    //通过BeanFactory来获取Bean
    public static User getBeanFromBeanFactory(){
        //1.加载配置文件为resource
        Resource resource = new ClassPathResource("spring-config.xml");
        //2.获取IOC容器对象,且容器会自动生成对象
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //3.根据ID获取你想要得到的对象
        return  (User) beanFactory.getBean("user", User.class);

    }

    //通过ApplicationContext获取bean
    public static User getBeanFromApplicationContext(){
        ApplicationContext applicationContext =
                       new ClassPathXmlApplicationContext("spring-config.xml");
        return (User)applicationContext.getBean("user",User.class);
    }
    public static void main( String[] args )
    {
       ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        try{
            @Cleanup Connection connection = dataSource.getConnection();
            String sql = "select username from users where id=?;";
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            @Cleanup ResultSet  resultSet =  preparedStatement.executeQuery();
           if (resultSet.next()){
               System.out.println(resultSet.getString("username"));
           }
        } catch (SQLException e1){
            e1.printStackTrace();
        } catch (Exception e2){
            e2.printStackTrace();
        }

      /* Dog dog = (Dog)applicationContext.getBean("dog");
        System.out.println(dog);*/

        //关闭ApplicationContext容器
       // ((AbstractApplicationContext)applicationContext).close();

    }
}
