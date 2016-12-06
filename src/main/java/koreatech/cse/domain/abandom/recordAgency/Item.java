
package koreatech.cse.domain.abandom.recordAgency;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "addr",
    "addrDtl",
    "memberNm",
    "orgNm",
    "tel",
    "email",
    "htel"
})
public class Item {

    @JsonProperty("addr")
    private String addr;
    @JsonProperty("addrDtl")
    private String addrDtl;
    @JsonProperty("memberNm")
    private String memberNm;
    @JsonProperty("orgNm")
    private String orgNm;
    @JsonProperty("tel")
    private String tel;
    @JsonProperty("email")
    private String email;
    @JsonProperty("htel")
    private String htel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The addr
     */
    @JsonProperty("addr")
    public String getAddr() {
        return addr;
    }

    /**
     * 
     * @param addr
     *     The addr
     */
    @JsonProperty("addr")
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 
     * @return
     *     The addrDtl
     */
    @JsonProperty("addrDtl")
    public String getAddrDtl() {
        return addrDtl;
    }

    /**
     * 
     * @param addrDtl
     *     The addrDtl
     */
    @JsonProperty("addrDtl")
    public void setAddrDtl(String addrDtl) {
        this.addrDtl = addrDtl;
    }

    /**
     * 
     * @return
     *     The memberNm
     */
    @JsonProperty("memberNm")
    public String getMemberNm() {
        return memberNm;
    }

    /**
     * 
     * @param memberNm
     *     The memberNm
     */
    @JsonProperty("memberNm")
    public void setMemberNm(String memberNm) {
        this.memberNm = memberNm;
    }

    /**
     * 
     * @return
     *     The orgNm
     */
    @JsonProperty("orgNm")
    public String getOrgNm() {
        return orgNm;
    }

    /**
     * 
     * @param orgNm
     *     The orgNm
     */
    @JsonProperty("orgNm")
    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    /**
     * 
     * @return
     *     The tel
     */
    @JsonProperty("tel")
    public String getTel() {
        return tel;
    }

    /**
     * 
     * @param tel
     *     The tel
     */
    @JsonProperty("tel")
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The htel
     */
    @JsonProperty("htel")
    public String getHtel() {
        return htel;
    }

    /**
     * 
     * @param htel
     *     The htel
     */
    @JsonProperty("htel")
    public void setHtel(String htel) {
        this.htel = htel;
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
