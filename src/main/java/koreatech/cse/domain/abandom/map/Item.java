
package koreatech.cse.domain.abandom.map;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "addrdetail",
    "isRoadAddress",
    "point"
})
public class Item {

    @JsonProperty("address")
    private String address;
    @JsonProperty("addrdetail")
    private Addrdetail addrdetail;
    @JsonProperty("isRoadAddress")
    private Boolean isRoadAddress;
    @JsonProperty("point")
    private Point point;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The addrdetail
     */
    @JsonProperty("addrdetail")
    public Addrdetail getAddrdetail() {
        return addrdetail;
    }

    /**
     * 
     * @param addrdetail
     *     The addrdetail
     */
    @JsonProperty("addrdetail")
    public void setAddrdetail(Addrdetail addrdetail) {
        this.addrdetail = addrdetail;
    }

    /**
     * 
     * @return
     *     The isRoadAddress
     */
    @JsonProperty("isRoadAddress")
    public Boolean getIsRoadAddress() {
        return isRoadAddress;
    }

    /**
     * 
     * @param isRoadAddress
     *     The isRoadAddress
     */
    @JsonProperty("isRoadAddress")
    public void setIsRoadAddress(Boolean isRoadAddress) {
        this.isRoadAddress = isRoadAddress;
    }

    /**
     * 
     * @return
     *     The point
     */
    @JsonProperty("point")
    public Point getPoint() {
        return point;
    }

    /**
     * 
     * @param point
     *     The point
     */
    @JsonProperty("point")
    public void setPoint(Point point) {
        this.point = point;
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
