
package koreatech.cse.domain.abandom.sigungu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "orgCd",
    "orgdownNm",
    "uprCd"
})
public class Item {

    @JsonProperty("orgCd")
    private Integer orgCd;
    @JsonProperty("orgdownNm")
    private String orgdownNm;
    @JsonProperty("uprCd")
    private Integer uprCd;

    /**
     * 
     * @return
     *     The orgCd
     */
    @JsonProperty("orgCd")
    public Integer getOrgCd() {
        return orgCd;
    }

    /**
     * 
     * @param orgCd
     *     The orgCd
     */
    @JsonProperty("orgCd")
    public void setOrgCd(Integer orgCd) {
        this.orgCd = orgCd;
    }

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
     *     The uprCd
     */
    @JsonProperty("uprCd")
    public Integer getUprCd() {
        return uprCd;
    }

    /**
     * 
     * @param uprCd
     *     The uprCd
     */
    @JsonProperty("uprCd")
    public void setUprCd(Integer uprCd) {
        this.uprCd = uprCd;
    }

}
