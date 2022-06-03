import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

        @Bean(name = "cat")
        @Scope(BeanDefinition.SCOPE_PROTOTYPE)
        public Cat getCat(){
            Cat cat = new Cat();
            cat.setCvet("Black");
            cat.setLapi(2);
            return cat;
        }
    }