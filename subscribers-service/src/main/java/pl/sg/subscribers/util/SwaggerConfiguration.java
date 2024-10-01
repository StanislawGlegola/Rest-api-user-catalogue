package pl.sg.subscribers.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.sg.subscribers.controller"))
                .paths(PathSelectors.ant("/subscribers/**"))
                .build()
                .pathMapping("/")
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Users catalog rest api")
                .description("Documentation of user catalog api containing " +
                        "information about its endpoints")
                .contact(new Contact("Stanislaw Glegola",
                        "https://github.com/StanislawGlegola",
                        "stanislaw.glegola@gmail.com"))
                .version("1.0.1")
                .build();
    }
}