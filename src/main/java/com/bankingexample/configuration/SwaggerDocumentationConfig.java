package com.bankingexample.configuration;

import com.bankingexample.model.Account;
import com.bankingexample.model.OperationType;
import com.bankingexample.model.Transaction;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-05T01:40:42.890Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.bankingexample.controller"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .ignoredParameterTypes(Account.class, OperationType.class, Transaction.class)
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Banking Example")
            .description("This API is responsible to deal with bank accounts and its transactions.")
            .license("MIT License")
            .licenseUrl("https://mit-license.org/")
            .termsOfServiceUrl("")
            .version("0.0.1")
            .contact(new Contact("","", "edilson.w3g@gmail.com"))
            .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Banking Example")
                .description("This API is responsible to deal with bank accounts and its transactions.")
                .termsOfService("")
                .version("0.0.1")
                .license(new License()
                    .name("MIT License")
                    .url("https://mit-license.org/"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("edilson.w3g@gmail.com")));
    }

}
