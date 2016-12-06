
package koreatech.cse.domain.abandom.shelter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "items"
})
public class Body {

    @JsonProperty("items")
    private Items items;

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public Items getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(Items items) {
        this.items = items;
    }

}
