package controllers;

import base.GatewayRequest;
import operations.products.*;
public class ProductsOperations {
    private GatewayRequest gatewayRequest;

    public ProductsOperations(GatewayRequest gatewayRequest) {
        this.gatewayRequest = gatewayRequest;
    }
    public GatewayRequest getAllProducts(GetAllProductReq getAllProductReq){
        gatewayRequest.setBody(getAllProductReq);
        gatewayRequest.setResponseObjectType(GetAllProductResp.class);
        return gatewayRequest;
    }
    public GatewayRequest addProduct(AddProductReq addProductReq){
        gatewayRequest.setBody(addProductReq);
        gatewayRequest.setResponseObjectType(AddProductResp.class);
        return gatewayRequest;
    }
    public GatewayRequest updateProduct(UpdateProductReq updateProductReq){
        gatewayRequest.setBody(updateProductReq);
        gatewayRequest.setResponseObjectType(UpdateProductResp.class);
        return gatewayRequest;
    }
    public GatewayRequest deleteProduct(DeleteProductReq deleteProductReq){
        gatewayRequest.setBody(deleteProductReq);
        gatewayRequest.setResponseObjectType(DeleteProductResp.class);
        return gatewayRequest;
    }
}