package co.com.pragma.util;


import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.HashMap;
import java.util.Map;

public class BaseHeaders {

    private final EnvironmentVariables environmentVariables;

    public BaseHeaders(EnvironmentVariables environmentVariables){
        this.environmentVariables = environmentVariables;
    }

    public Map<String, String> getBaseHeader(){
        Map<String , String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Acept-Encoding", "gzip, deflate, br");
        return headers;
    }

    public Map<String, String> getHeaderWithEnv() {
        Map<String, String> headers = new HashMap<>();
        headers.put("header1", EnvironmentSpecificConfiguration.from(this.environmentVariables).getProperty("property.header1"));
        return headers;
    }
}
