package base;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class HttpDispatcher {
    private String jsonBody = null;

    public HttpResponse<JsonNode> send(GatewayRequest gatewayRequest) {

        HttpRequest request = null;
        HttpResponse response = null;

        final String url = gatewayRequest.getBody().getEndpointUrl();
        final HttpMethod method = gatewayRequest.getBody().getHttpMethod();


        try {
            request = new HttpRequestWithBody(method, url);
            request.headers(gatewayRequest.getHeaders().getHeader());
            request.header("Content-Type", "application/json");

            jsonBody = new Gson().toJson(gatewayRequest.getBody());

            try {
                response = ((HttpRequestWithBody) request).body(jsonBody).asJson();
                gatewayRequest.setHttpResponse(response);
            } catch (Exception e) {
                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
                gatewayRequest.setHttpResponse(response);
//                   Assert.fail("Invalid HTTP Response: " + response.getBody());
            }

            try {
                if (gatewayRequest.getResponseObjectType() != null) {
                    gatewayRequest.setSerializedResponse(new Gson().fromJson(response.getBody().toString(), gatewayRequest.getResponseObjectType()));
                }
            } catch (Exception e) {

            }


        } catch (Exception e) {
            try {
                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
            } catch (UnirestException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();


        }
        return response;
    }
}



