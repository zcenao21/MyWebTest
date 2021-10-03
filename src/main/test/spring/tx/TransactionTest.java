package spring.tx;

import com.will.spring.tx.OrdersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    @Test
    public void testTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/tx/beans.xml");
        OrdersService service = (OrdersService)context.getBean("ordersService");
        service.addAccountMoney();
    }
}
