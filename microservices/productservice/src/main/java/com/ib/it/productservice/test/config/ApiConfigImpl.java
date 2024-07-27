package com.ib.it.productservice.test.config;

import interfaces.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@Scope("prototype")
public class ApiConfigImpl extends ApiConfig {

    private static final String BASE_API_SETTINGS = "api-settings.api";
    private final Environment environment;

    @Autowired
    public ApiConfigImpl(Environment environment) {
        this.environment = environment;
        this.baseUrl = environment.getProperty("api-settings.base-url");
        System.out.println("ApiConfigImpl constructor: " + this.baseUrl);
    }

    @Override
    public String getApiUrl(String serviceName, String parameters) {
        var name = BASE_API_SETTINGS + "." + serviceName.toLowerCase();
        var url = this.environment.getProperty(name);
        var version = this.environment.getProperty("api-settings.version") == null ? "v1" :
                this.environment.getProperty("api-settings.version");
        url = url.replace("{version}", version);

        return getApiUrlInternal(url, parameters);
    }
}
