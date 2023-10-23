package com.newspapers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//
//
@Configuration
//@EnableSwagger2
@OpenAPIDefinition
//@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {
//
    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI().info(new Info().title("Newspaper").version("1.0").description("Newspepersssss"));
    }
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
//                .paths((Predicate<String>) PathSelectors.any())
//                .build();
//    }
//
//
}