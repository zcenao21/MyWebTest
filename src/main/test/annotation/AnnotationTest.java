package annotation;

import com.will.annotation.inner.Boy;
import com.will.annotation.MainClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {
    @Test
    public void testDI() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Boy.class);
        Boy boy = (Boy)context.getBean("boy");
        boy.drive();
    }
}
