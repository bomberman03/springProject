
package koreatech.cse.domain.abandom.shelter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "careNm",
    "careRegNo"
})
public class Item {

    @JsonProperty("careNm")
    private String careNm;
    @JsonProperty("careRegNo")
    private Integer careRegNo;

    /**
     * 
     * @return
     *     The careNm
     */
    @JsonProperty("careNm")
    public String getCareNm() {
        return careNm;
    }

    /**
     * 
     * @param careNm
     *     The careNm
     */
    @JsonProperty("careNm")
    public void setCareNm(String careNm) {
        this.careNm = careNm;
    }

    /**
     * 
     * @return
     *     The careRegNo
     */
    @JsonProperty("careRegNo")
    public Integer getCareRegNo() {
        return careRegNo;
    }

    /**
     * 
     * @param careRegNo
     *     The careRegNo
     */
    @JsonProperty("careRegNo")
    public void setCareRegNo(Integer careRegNo) {
        this.careRegNo = careRegNo;
    }

}
