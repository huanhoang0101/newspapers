package com.newspapers;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
//@EnableSwagger2
//@OpenAPIDefinition(info = @Info(title = "Newspaper", version = "1.0", description = "Newspaperssss"))
public class NewspapersApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewspapersApplication.class, args);
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.newspapers")).build();
//    }

}
