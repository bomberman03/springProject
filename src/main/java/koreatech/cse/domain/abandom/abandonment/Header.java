
package koreatech.cse.domain.abandom.abandonment;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "resultCode",
    "resultMsg"
})
public class Header {

    @JsonProperty("resultCode")
    private String resultCode;
    @JsonProperty("resultMsg")
    private String resultMsg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 
     * @param resultCode
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 
     * @return
     *     The resultMsg
     */
    @JsonProperty("resultMsg")
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * 
     * @param resultMsg
     *     The resultMsg
     */
    @JsonProperty("resultMsg")
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
