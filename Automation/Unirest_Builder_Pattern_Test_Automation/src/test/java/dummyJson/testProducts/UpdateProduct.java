package dummyJson.testProducts;

import base.GatewayRequest;
import helpers.AssertHelper;
import helpers.Header;
import operations.products.UpdateProductReq;
import operations.products.UpdateProductResp;
import org.testng.annotations.Test;

public class UpdateProduct {
    @Test
    public void testUpdateProduct() {
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(Header.getHeaders())
                .forService()
                .productsOperations()
                .updateProduct(
                        UpdateProductReq
                                .builder()
                                .productId(1)
                                .title("Nokia 14 pro max")
                                .build())
                .send();


        AssertHelper.assertResponseCode(gatewayRequest, 200);

        UpdateProductResp resp = (UpdateProductResp) gatewayRequest.getSerializedResponse();

    }
}
