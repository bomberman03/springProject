
package koreatech.cse.domain.abandom.province;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "orgdownNm",
    "orgCd"
})
public class Record {

    @JsonProperty("orgdownNm")
    private String orgdownNm;
    @JsonProperty("orgCd")
    private String orgCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The orgdownNm
     */
    @JsonProperty("orgdownNm")
    public String getOrgdownNm() {
        return orgdownNm;
    }

    /**
     * 
     * @param orgdownNm
     *     The orgdownNm
     */
    @JsonProperty("orgdownNm")
    public void setOrgdownNm(String orgdownNm) {
        this.orgdownNm = orgdownNm;
    }

    /**
     * 
     * @return
     *     The orgCd
     */
    @JsonProperty("orgCd")
    public String getOrgCd() {
        return orgCd;
    }

    /**
     * 
     * @param orgCd
     *     The orgCd
     */
    @JsonProperty("orgCd")
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
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
