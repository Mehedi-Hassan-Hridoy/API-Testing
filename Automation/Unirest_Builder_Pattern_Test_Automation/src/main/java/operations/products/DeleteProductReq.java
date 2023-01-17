package operations.products;

import base.AbstractHttpSpecification;
import base.Properties;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Getter
@Setter
public class DeleteProductReq extends AbstractHttpSpecification {
    private transient Integer productId;
    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.dummyJsonApi+"products/"+productId;

    }
}
