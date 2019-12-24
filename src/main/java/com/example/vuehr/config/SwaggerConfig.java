package com.example.vuehr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Xu
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                /*
                 * 通过apis方法配置要扫描的controller位置
                 */
                .apis(RequestHandlerSelectors.basePackage("com.example.vuehr.controller"))
                /*
                   通过path方法配置路径
                 */
                .paths(PathSelectors.any())
                .build()
                /*
                   在apiInfo中配置文档的基本信息，例如描述、联系人信息、版本、标题等
                 */
                .apiInfo(new ApiInfoBuilder()
                        .description("接口测试文档")
                        .contact(new Contact("xxxxs", "https://github.com/lenve", "xxxxurobot@gmail.com"))
                        .version("v1.0")
                        .title("API测试文档")
                        .license("Apache2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                        .build()
                );

    }
}
