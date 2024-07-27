package interfaces;

import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
@Setter
public abstract class ApiConfig {

    protected String baseUrl;
    protected String apiVersion;

    public String getApiUrlInternal(String serviceName, String parameters) {
        return baseUrl + serviceName + parameters;
    }

    public abstract String getApiUrl(String serviceName, String parameters);


}
