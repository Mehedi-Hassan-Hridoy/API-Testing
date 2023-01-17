package operations.products;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

public class GetAllProductResp {
    private List<Products> posts;
    private List<String>images;

    @Getter
    public class Products{

        @SerializedName("id")
        private int id;

        @SerializedName("title")
        private String title;

        @SerializedName("description")
        private String description;
        @SerializedName("price")
        private double price;
        @SerializedName("discountPercentage")
        private float discountPercentage;
        @SerializedName("rating")
        private float rating;
        @SerializedName("stock")
        private int stock;
        @SerializedName("brand")
        private String brand;
        @SerializedName("category")
        private String category;
        @SerializedName("thumbnail")
        private String thumbnail;
        @SerializedName("image")
        private List<String>images =GetAllProductResp.this.images;

    }
}
