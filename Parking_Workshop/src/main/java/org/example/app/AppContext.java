package org.example.app;

//Para usar esto revisar el pom.xml la dependencia de "springframework"
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {

    private static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext("org.example"); //Asi es mas facil, porque no escanea todo el proyecto
    //ComponentScan

    private AppContext(){}

    public static ApplicationContext getInstance(){
        return applicationContext;
    }

}