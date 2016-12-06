
package koreatech.cse.domain.blogandshop.meshup;

import com.fasterxml.jackson.annotation.*;
import koreatech.cse.domain.blogandshop.meshup.Item;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "result",
    "title",
    "sort",
    "desc",
    "totalCount",
    "q",
    "item",
    "pageno"
})
public class Channel {

    @JsonProperty("result")
    private String result;
    @JsonProperty("title")
    private String title;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("q")
    private String q;
    @JsonProperty("item")
    private List<Item> item = new ArrayList<Item>();
    @JsonProperty("pageno")
    private String pageno;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The result
     */
    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The sort
     */
    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    /**
     * 
     * @param sort
     *     The sort
     */
    @JsonProperty("sort")
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return
     *     The desc
     */
    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc
     *     The desc
     */
    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
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

    /**
     * 
     * @return
     *     The q
     */
    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    /**
     * 
     * @param q
     *     The q
     */
    @JsonProperty("q")
    public void setQ(String q) {
        this.q = q;
    }

    /**
     * 
     * @return
     *     The item
     */
    @JsonProperty("item")
    public List<Item> getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    @JsonProperty("item")
    public void setItem(List<Item> item) {
        this.item = item;
    }

    /**
     * 
     * @return
     *     The pageno
     */
    @JsonProperty("pageno")
    public String getPageno() {
        return pageno;
    }

    /**
     * 
     * @param pageno
     *     The pageno
     */
    @JsonProperty("pageno")
    public void setPageno(String pageno) {
        this.pageno = pageno;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "result='" + result + '\'' +
                ", title='" + title + '\'' +
                ", sort='" + sort + '\'' +
                ", desc='" + desc + '\'' +
                ", totalCount=" + totalCount +
                ", q='" + q + '\'' +
                ", item=" + item +
                ", pageno='" + pageno + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
