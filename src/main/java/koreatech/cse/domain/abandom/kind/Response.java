
package koreatech.cse.domain.abandom.kind;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "header",
    "body"
})
public class Response {

    @JsonProperty("header")
    private Header header;
    @JsonProperty("body")
    private Body body;

    /**
     * 
     * @return
     *     The header
     */
    @JsonProperty("header")
    public Header getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    @JsonProperty("header")
    public void setHeader(Header header) {
        this.header = header;
    }

    /**
     * 
     * @return
     *     The body
     */
    @JsonProperty("body")
    public Body getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    @JsonProperty("body")
    public void setBody(Body body) {
        this.body = body;
    }

}
