package pl.edu.agh.two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Test bean = applicationContext.getBean(Test.class);
        System.out.println(bean.getTest2().getHelloMessage());
    }
}
