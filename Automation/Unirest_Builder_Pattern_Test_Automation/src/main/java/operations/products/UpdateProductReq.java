package operations.products;

import base.AbstractHttpSpecification;
import base.Properties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Getter
@Setter
public class UpdateProductReq extends AbstractHttpSpecification {
    @SerializedName("title")
    @Expose
    private String title;
    private transient Integer productId;
    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.dummyJsonApi+"products/"+productId;

    }
}
