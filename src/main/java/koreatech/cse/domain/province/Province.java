
package koreatech.cse.domain.province;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "fields",
    "records"
})
public class Province {

    @JsonProperty("fields")
    private List<Field> fields = new ArrayList<Field>();
    @JsonProperty("records")
    private List<Record> records = new ArrayList<Record>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The fields
     */
    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    /**
     * 
     * @param fields
     *     The fields
     */
    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * 
     * @return
     *     The records
     */
    @JsonProperty("records")
    public List<Record> getRecords() {
        return records;
    }

    /**
     * 
     * @param records
     *     The records
     */
    @JsonProperty("records")
    public void setRecords(List<Record> records) {
        this.records = records;
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
