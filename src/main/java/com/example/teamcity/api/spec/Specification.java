package com.example.teamcity.api.spec;

import com.example.teamcity.api.config.Config;
import com.example.teamcity.api.models.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
    private static Specification spec;

    private Specification() {}

    public static Specification getSpec() {
        if (spec == null) {
            spec = new Specification();
        }
        return spec;
    }

    private RequestSpecBuilder reqBuilder(){
        var requeaBuilder = new RequestSpecBuilder();
        requeaBuilder.addFilter(new RequestLoggingFilter());
        requeaBuilder.addFilter(new ResponseLoggingFilter());
        return  requeaBuilder;
    }

    public RequestSpecification unauthSpec(){
        var requeaBuilder = reqBuilder();
        requeaBuilder.setContentType(ContentType.JSON);
        requeaBuilder.setAccept(ContentType.JSON);
        return requeaBuilder.build();
    }

    public RequestSpecification authSpec(User user){
        var requeaBuilder = reqBuilder();
        requeaBuilder.setBaseUri("http://"+ user.getUsername()+":"+ user.getPassword()+"@"+ Config.getProperty("host"));
        return requeaBuilder.build();
    }
}
