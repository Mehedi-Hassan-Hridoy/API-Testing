package operations.products;

import base.AbstractHttpSpecification;
import base.Properties;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;

import java.util.List;
@Builder
public class AddProductReq extends AbstractHttpSpecification {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;
    @SerializedName("discountPercentage")
    private double discountPercentage;
    @SerializedName("rating")
    private double rating;
    @SerializedName("stock")
    private int stock;
    @SerializedName("brand")
    private String brand;
    @SerializedName("category")
    private String category;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("image")
    private String images;
            //=GetAllProductResp.this.images;

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.dummyJsonApi+"products/add";
    }
}
