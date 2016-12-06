
package koreatech.cse.domain.abandom.map;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "country",
    "sido",
    "sigugun",
    "dongmyun",
    "rest"
})
public class Addrdetail {

    @JsonProperty("country")
    private String country;
    @JsonProperty("sido")
    private String sido;
    @JsonProperty("sigugun")
    private String sigugun;
    @JsonProperty("dongmyun")
    private String dongmyun;
    @JsonProperty("rest")
    private String rest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The sido
     */
    @JsonProperty("sido")
    public String getSido() {
        return sido;
    }

    /**
     * 
     * @param sido
     *     The sido
     */
    @JsonProperty("sido")
    public void setSido(String sido) {
        this.sido = sido;
    }

    /**
     * 
     * @return
     *     The sigugun
     */
    @JsonProperty("sigugun")
    public String getSigugun() {
        return sigugun;
    }

    /**
     * 
     * @param sigugun
     *     The sigugun
     */
    @JsonProperty("sigugun")
    public void setSigugun(String sigugun) {
        this.sigugun = sigugun;
    }

    /**
     * 
     * @return
     *     The dongmyun
     */
    @JsonProperty("dongmyun")
    public String getDongmyun() {
        return dongmyun;
    }

    /**
     * 
     * @param dongmyun
     *     The dongmyun
     */
    @JsonProperty("dongmyun")
    public void setDongmyun(String dongmyun) {
        this.dongmyun = dongmyun;
    }

    /**
     * 
     * @return
     *     The rest
     */
    @JsonProperty("rest")
    public String getRest() {
        return rest;
    }

    /**
     * 
     * @param rest
     *     The rest
     */
    @JsonProperty("rest")
    public void setRest(String rest) {
        this.rest = rest;
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
