package com.optum.apiengine.model.response;

import io.restassured.response.Response;

public class RestResponse {
    
    private Response response;
    private Exception e;

    public RestResponse(Response response) {
        this.response = response;
    }

    public String getContent() {
        return response.getBody().asString();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public boolean isSuccessful() {
        int code = response.getStatusCode();
        if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
        return false;
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponse() {
        return response;
    }


    public String getBody() {
        String data = null;
        try {
            data = response.getBody().as(String.class);
        }catch (Exception e) {
            this.e=e;
        }
        return data;
    }

    public Exception getException() {
        return e;
    }

}
