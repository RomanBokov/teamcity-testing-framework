package com.example.teamcity.api.spec;

import com.example.teamcity.api.config.Config;
import com.example.teamcity.api.models.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {
    private static Specifications spec;

    private Specifications() {}

    private static RequestSpecBuilder reqBuilder(){
        var requeaBuilder = new RequestSpecBuilder();
        requeaBuilder.addFilter(new RequestLoggingFilter());
        requeaBuilder.addFilter(new ResponseLoggingFilter());
        requeaBuilder.setContentType(ContentType.JSON);
        requeaBuilder.setAccept(ContentType.JSON);
        return  requeaBuilder;
    }

    public static RequestSpecification superUserAuth(){
        var requeaBuilder = reqBuilder();
        requeaBuilder.setBaseUri("http://%s:%s@%s".formatted("",Config.getProperty("superUserToken"),Config.getProperty("host")));
        return requeaBuilder.build();
    }

    public static RequestSpecification unauthSpec(){
        var requeaBuilder = reqBuilder();
        return requeaBuilder.build();
    }

    public static RequestSpecification authSpec(User user){
        var requeaBuilder = reqBuilder();
        requeaBuilder.setBaseUri("http://%s:%s@%s".formatted(user.getUsername(),user.getPassword(),Config.getProperty("host")));
        return requeaBuilder.build();
    }
}
