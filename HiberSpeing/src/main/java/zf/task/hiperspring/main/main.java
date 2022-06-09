package zf.task.hiperspring.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zf.task.hiperspring.java_config.AppConfig;
import zf.task.hiperspring.model.Car;
import zf.task.hiperspring.service.UserService;

public class main {

    public static void main(String[] args) {

        Car car = new Car();
        car.setModel("Beha");
        car.setSeries(34343213);
        Car car2 = new Car();
        car2.setModel("Mersedes");
        car2.setSeries(4598946);
        Car car3 = new Car();
        car3.setModel("Lada");
        car3.setSeries(9874543);


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

//        userService.saveUser("Vovpen", "Sobaka", car);
//        userService.saveUser("Vanpen", "Levcha", car2);
//        userService.saveUser("Irpen", "Snezhiha", car3);

        //       System.out.println(userService.getAllUsers());

        System.out.println(userService.getUserByCar("Mersedes", 4598946));


    }
}
