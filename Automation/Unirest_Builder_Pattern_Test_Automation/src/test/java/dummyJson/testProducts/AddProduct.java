package dummyJson.testProducts;

import base.GatewayRequest;
import helpers.AssertHelper;
import helpers.Header;
import operations.products.AddProductReq;
import operations.products.AddProductResp;
import org.testng.annotations.Test;

public class AddProduct {
    @Test
    public void testAddProduct(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(Header.getHeaders())
                .forService()
                .productsOperations()
                .addProduct(
                        AddProductReq
                                .builder()
                                .id(101)
                                .title("iphone 14 pro max")
                                .description("Iphone say Hello to Users")
                                .price(12345)
                                .discountPercentage(10.12)
                                .rating(4.5)
                                .stock(20)
                                .brand("Apple")
                                .category("SmartPhone")
                                .thumbnail("https://i.dummyjson.com/data/products/101/thumbnail.jpg")
                                .images("https://i.dummyjson.com/data/products/101/1.jpg")
                                .images("https://i.dummyjson.com/data/products/101/2.jpg")
                                .build())
                .send();

        AddProductResp creationResp = (AddProductResp) gatewayRequest.getSerializedResponse();

        AssertHelper.assertResponseCode(gatewayRequest, 201);
//        AssertHelper.assertResponseBodyContains("title", creationResp.getTitle(), "abcd");
    }
}
