package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"proxies", "repositories", "services"})
@ComponentScan(basePackages = "org.example")
public class AppConfig {
}
