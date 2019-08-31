package org.starrier.imperator.content.config.swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author Starrier
 * @Time 2018/10/27.
 */
@Slf4j
@Configuration
public class Swagger2Config {

    /**
     * <p>Configuration</p>
     * <p>Swagger2 for Base Configuration</p>
     * <p>package,path etc...</p>
     * <p>
     * {@link Docket}
     *
     * @return Swagger configuration file.
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.starrier.dreamwar.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * <p>Swagger Information</p>
     * <p>Detail Information for Swagger2 API to be build</p>
     * {@link ApiInfo}
     *
     * @return Swagger Information will be return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Imperator-Content")
                .description("RESTful API for Imperator")
                .termsOfServiceUrl("http://api.starrier.org")
                .version("0.0.1-SNAPSHOT")
                .build();

    }
}
