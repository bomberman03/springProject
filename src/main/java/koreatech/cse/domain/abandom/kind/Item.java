
package koreatech.cse.domain.abandom.kind;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "KNm",
    "kindCd"
})
public class Item {

    @JsonProperty("KNm")
    private String kNm;
    @JsonProperty("kindCd")
    private String kindCd;

    /**
     * 
     * @return
     *     The kNm
     */
    @JsonProperty("KNm")
    public String getKNm() {
        return kNm;
    }

    /**
     * 
     * @param kNm
     *     The KNm
     */
    @JsonProperty("KNm")
    public void setKNm(String kNm) {
        this.kNm = kNm;
    }

    /**
     * 
     * @return
     *     The kindCd
     */
    @JsonProperty("kindCd")
    public String getKindCd() {
        return kindCd;
    }

    /**
     * 
     * @param kindCd
     *     The kindCd
     */
    @JsonProperty("kindCd")
    public void setKindCd(String kindCd) {
        this.kindCd = kindCd;
    }

}
