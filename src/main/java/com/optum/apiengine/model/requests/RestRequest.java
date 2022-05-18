package com.optum.apiengine.model.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestRequest {

    private static RequestSpecification reqSpec;

    public static Response get(String baseUri, String path) {
        reqSpec =  RestAssured.given().
                contentType(ContentType.JSON).
                baseUri(baseUri).
                basePath(path);
        return reqSpec.get();
    }

    public static Response post(String baseUri, String path, String body) {
        reqSpec =  RestAssured.given().
                contentType(ContentType.JSON).
                baseUri(baseUri).
                basePath(path).
                body(body);
        return reqSpec.post();
    }

    public static Response auth(String baseUri, String path, String body) {
        reqSpec =  RestAssured.given().
                contentType(ContentType.JSON).
                baseUri(baseUri).
                basePath(path);
        return reqSpec.get();
    }

    public static Response delete(String baseUri, String path) {
        reqSpec =  RestAssured.given().
                contentType(ContentType.JSON).
                baseUri(baseUri).
                basePath(path);
        return reqSpec.delete();
    }

    public static Response put(String baseUri, String path, String body) {
        reqSpec =  RestAssured.given().
                contentType(ContentType.JSON).
                baseUri(baseUri).
                basePath(path);
        return reqSpec.put();
    }
}
