package com.example.teamcity.api.requests;

import java.util.EnumMap;
import com.example.teamcity.api.enums.Endpoint;
import com.example.teamcity.api.requests.unchecked.UncheckedBase;
import io.restassured.specification.RequestSpecification;

public class UnchekedRequests {
    private  final EnumMap<Endpoint, UncheckedBase> requests = new EnumMap<>(Endpoint.class);

    public UnchekedRequests(RequestSpecification spec) {
        for(var endpoint : Endpoint.values()) {
            requests.put(endpoint, new UncheckedBase(spec, endpoint));
        }
    }

    public UncheckedBase getRequester(Endpoint endpoint) {
        return requests.get(endpoint);
    }

}
