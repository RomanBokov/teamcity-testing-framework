package com.example.teamcity.api.requests;

import com.example.teamcity.api.enums.Endpoint;
import io.restassured.specification.RequestSpecification;

public class Request {
    /**
     * Request - это класс описывающий меняющиеся параметры запроса, такие как спецификация,эндпоинт
     * (relative URL. model)
     **/
    protected final RequestSpecification sprc;
    protected final Endpoint endpoint;

    public Request(RequestSpecification sprc, Endpoint endpoint) {
        this.sprc = sprc;
        this.endpoint = endpoint;
    }
}
