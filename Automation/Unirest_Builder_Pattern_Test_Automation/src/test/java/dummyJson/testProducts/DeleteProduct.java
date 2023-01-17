package dummyJson.testProducts;

import base.GatewayRequest;
import helpers.AssertHelper;
import helpers.Header;
import operations.products.DeleteProductReq;
import operations.products.DeleteProductResp;
import operations.products.UpdateProductResp;
import org.testng.annotations.Test;

public class DeleteProduct {
    @Test
    public void testDeleteProduct() {
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(Header.getHeaders())
                .forService()
                .productsOperations()
                .deleteProduct(
                        DeleteProductReq
                                .builder()
                                .productId(1)
                                .build())
                .send();


        AssertHelper.assertResponseCode(gatewayRequest, 200);

        DeleteProductResp resp = (DeleteProductResp) gatewayRequest.getSerializedResponse();

    }
}
