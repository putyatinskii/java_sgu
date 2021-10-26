package ru.hospital.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HospitalApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HospitalApplication.class);

    }
}
