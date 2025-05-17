package springboot.reactive.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.reactive.api.student.Student;
import springboot.reactive.api.student.StudentService;

@SpringBootApplication
public class SpringbootReactiveApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReactiveApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService service) {
        return args -> {
           for(int i = 0 ; i < 100; i++){
               service.save(
                       Student.builder()
                               .firstname("John "+i)
                               .lastname("Doe "+i)
                               .age(i)
                               .build()
               ).subscribe();
           }
        };

    }

}
