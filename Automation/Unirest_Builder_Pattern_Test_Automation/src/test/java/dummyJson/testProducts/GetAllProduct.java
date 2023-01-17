package dummyJson.testProducts;

import base.GatewayRequest;
import helpers.AssertHelper;
import helpers.Header;
import operations.products.GetAllProductReq;

import org.testng.annotations.Test;

public class GetAllProduct {
    @Test
    public void testGetAllProducts() {
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(Header.getHeaders())
                .forService() //why this method
                .productsOperations()//same q
                .getAllProducts(GetAllProductReq.builder().build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);

        System.out.println(gatewayRequest.getHttpResponse().getBody());
    }
}
