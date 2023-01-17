package operations.products;

import base.AbstractHttpSpecification;

import base.Properties;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;
import lombok.experimental.Accessors;

import java.util.Hashtable;

@Builder
@Accessors(chain = true)
public class GetAllProductReq extends AbstractHttpSpecification {

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.dummyJsonApi + "/products";
    }
}
