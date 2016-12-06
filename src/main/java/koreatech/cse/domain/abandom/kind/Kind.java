
package koreatech.cse.domain.abandom.kind;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "response"
})
public class Kind {

    @JsonProperty("response")
    private Response response;

    /**
     * 
     * @return
     *     The response
     */
    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
    }

}
