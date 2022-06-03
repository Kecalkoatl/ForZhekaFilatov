import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2 =
                (HelloWorld) applicationContext.getBean("helloworld");

        Cat cat1 =
                (Cat) applicationContext.getBean("cat");
        Cat cat2 =
                (Cat) applicationContext.getBean("cat");


        System.out.println("Comparing shoud be true: " + bean.equals(bean2) + "\nComparing should be false: " + cat1.equals(cat2));
    }
}