
package koreatech.cse.domain.abandom.map;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "x",
    "y"
})
public class Point {

    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The x
     */
    @JsonProperty("x")
    public Double getX() {
        return x;
    }

    /**
     * 
     * @param x
     *     The x
     */
    @JsonProperty("x")
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * 
     * @return
     *     The y
     */
    @JsonProperty("y")
    public Double getY() {
        return y;
    }

    /**
     * 
     * @param y
     *     The y
     */
    @JsonProperty("y")
    public void setY(Double y) {
        this.y = y;
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
