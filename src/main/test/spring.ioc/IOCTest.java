package spring.ioc;

import com.will.spring.ioc.Car;
import com.will.spring.ioc.SimpleIoc;
import com.will.spring.ioc.Wheel;
import org.junit.Test;

public class IOCTest {

    @Test
    public void testIOC(){
        try{
//            SimpleIoc ioc = new SimpleIoc("/home/will/study/projects/MyWebTest/src/main/resources/spring/ioc/ioc.xml");
            SimpleIoc ioc = new SimpleIoc("E:\\projects\\MyWebTest\\src\\main\\resources\\spring\\ioc\\ioc.xml");
            Wheel wheel = (Wheel) ioc.getObj("wheel");
            Car car = (Car) ioc.getObj("car");
            System.out.println("wheel class:"+wheel);
            System.out.println("Car class:"+car);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
