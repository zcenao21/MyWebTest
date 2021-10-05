package spring.tx;

import com.will.spring.tx.OrdersService;
import com.will.spring.tx.OrdersServiceAnnotation;
import com.will.spring.tx.OrdersServiceAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    @Test
    public void testTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/tx/beans.xml");
        OrdersService service = (OrdersService) context.getBean("ordersService");
        service.addAccountMoney();
    }

    @Test
    public void testTransactionAop() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/tx/beans-aop.xml");
            OrdersServiceAop service = (OrdersServiceAop) context.getBean("ordersServiceAop");
            service.accountMoney();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTransactionAnnotation() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/tx/beans-annotation.xml");
            OrdersServiceAnnotation service = (OrdersServiceAnnotation) context.getBean("ordersServiceAnnotation");
            service.accountMoney();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
