
package koreatech.cse.domain.abandom.abandonment;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "items",
    "numOfRows",
    "pageNo",
    "totalCount"
})
public class Body {

    @JsonProperty("items")
    private Items items;
    @JsonProperty("numOfRows")
    private Integer numOfRows;
    @JsonProperty("pageNo")
    private Integer pageNo;
    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * 
     * @return
     *     The numOfRows
     */
    @JsonProperty("numOfRows")
    public Integer getNumOfRows() {
        return numOfRows;
    }

    /**
     * 
     * @param numOfRows
     *     The numOfRows
     */
    @JsonProperty("numOfRows")
    public void setNumOfRows(Integer numOfRows) {
        this.numOfRows = numOfRows;
    }

    /**
     * 
     * @return
     *     The pageNo
     */
    @JsonProperty("pageNo")
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 
     * @param pageNo
     *     The pageNo
     */
    @JsonProperty("pageNo")
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 
     * @return
     *     The totalCount
     */
    @JsonProperty("totalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 
     * @param totalCount
     *     The totalCount
     */
    @JsonProperty("totalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
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
