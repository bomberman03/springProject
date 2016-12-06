
package koreatech.cse.domain.abandom.map;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "userquery",
    "items"
})
public class Result {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("userquery")
    private String userquery;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The userquery
     */
    @JsonProperty("userquery")
    public String getUserquery() {
        return userquery;
    }

    /**
     * 
     * @param userquery
     *     The userquery
     */
    @JsonProperty("userquery")
    public void setUserquery(String userquery) {
        this.userquery = userquery;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
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
