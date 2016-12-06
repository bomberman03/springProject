
package koreatech.cse.domain.abandom.abandonment;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "age",
    "careAddr",
    "careNm",
    "careTel",
    "chargeNm",
    "colorCd",
    "desertionNo",
    "filename",
    "happenDt",
    "happenPlace",
    "kindCd",
    "neuterYn",
    "noticeEdt",
    "noticeNo",
    "noticeSdt",
    "officetel",
    "orgNm",
    "popfile",
    "processState",
    "sexCd",
    "specialMark",
    "weight"
})
public class Item {

    @JsonProperty("age")
    private String age;
    @JsonProperty("careAddr")
    private String careAddr;
    @JsonProperty("careNm")
    private String careNm;
    @JsonProperty("careTel")
    private String careTel;
    @JsonProperty("chargeNm")
    private String chargeNm;
    @JsonProperty("colorCd")
    private String colorCd;
    @JsonProperty("desertionNo")
    private Long desertionNo;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("happenDt")
    private Integer happenDt;
    @JsonProperty("happenPlace")
    private String happenPlace;
    @JsonProperty("kindCd")
    private String kindCd;
    @JsonProperty("neuterYn")
    private String neuterYn;
    @JsonProperty("noticeEdt")
    private Integer noticeEdt;
    @JsonProperty("noticeNo")
    private String noticeNo;
    @JsonProperty("noticeSdt")
    private Integer noticeSdt;
    @JsonProperty("officetel")
    private String officetel;
    @JsonProperty("orgNm")
    private String orgNm;
    @JsonProperty("popfile")
    private String popfile;
    @JsonProperty("processState")
    private String processState;
    @JsonProperty("sexCd")
    private String sexCd;
    @JsonProperty("specialMark")
    private String specialMark;
    @JsonProperty("weight")
    private String weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The age
     */
    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 
     * @return
     *     The careAddr
     */
    @JsonProperty("careAddr")
    public String getCareAddr() {
        return careAddr;
    }

    /**
     * 
     * @param careAddr
     *     The careAddr
     */
    @JsonProperty("careAddr")
    public void setCareAddr(String careAddr) {
        this.careAddr = careAddr;
    }

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
     *     The careTel
     */
    @JsonProperty("careTel")
    public String getCareTel() {
        return careTel;
    }

    /**
     * 
     * @param careTel
     *     The careTel
     */
    @JsonProperty("careTel")
    public void setCareTel(String careTel) {
        this.careTel = careTel;
    }

    /**
     * 
     * @return
     *     The chargeNm
     */
    @JsonProperty("chargeNm")
    public String getChargeNm() {
        return chargeNm;
    }

    /**
     * 
     * @param chargeNm
     *     The chargeNm
     */
    @JsonProperty("chargeNm")
    public void setChargeNm(String chargeNm) {
        this.chargeNm = chargeNm;
    }

    /**
     * 
     * @return
     *     The colorCd
     */
    @JsonProperty("colorCd")
    public String getColorCd() {
        return colorCd;
    }

    /**
     * 
     * @param colorCd
     *     The colorCd
     */
    @JsonProperty("colorCd")
    public void setColorCd(String colorCd) {
        this.colorCd = colorCd;
    }

    /**
     * 
     * @return
     *     The desertionNo
     */
    @JsonProperty("desertionNo")
    public Long getDesertionNo() {
        return desertionNo;
    }

    /**
     * 
     * @param desertionNo
     *     The desertionNo
     */
    @JsonProperty("desertionNo")
    public void setDesertionNo(Long desertionNo) {
        this.desertionNo = desertionNo;
    }

    /**
     * 
     * @return
     *     The filename
     */
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * @param filename
     *     The filename
     */
    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 
     * @return
     *     The happenDt
     */
    @JsonProperty("happenDt")
    public Integer getHappenDt() {
        return happenDt;
    }

    /**
     * 
     * @param happenDt
     *     The happenDt
     */
    @JsonProperty("happenDt")
    public void setHappenDt(Integer happenDt) {
        this.happenDt = happenDt;
    }

    /**
     * 
     * @return
     *     The happenPlace
     */
    @JsonProperty("happenPlace")
    public String getHappenPlace() {
        return happenPlace;
    }

    /**
     * 
     * @param happenPlace
     *     The happenPlace
     */
    @JsonProperty("happenPlace")
    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace;
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

    /**
     * 
     * @return
     *     The neuterYn
     */
    @JsonProperty("neuterYn")
    public String getNeuterYn() {
        return neuterYn;
    }

    /**
     * 
     * @param neuterYn
     *     The neuterYn
     */
    @JsonProperty("neuterYn")
    public void setNeuterYn(String neuterYn) {
        this.neuterYn = neuterYn;
    }

    /**
     * 
     * @return
     *     The noticeEdt
     */
    @JsonProperty("noticeEdt")
    public Integer getNoticeEdt() {
        return noticeEdt;
    }

    /**
     * 
     * @param noticeEdt
     *     The noticeEdt
     */
    @JsonProperty("noticeEdt")
    public void setNoticeEdt(Integer noticeEdt) {
        this.noticeEdt = noticeEdt;
    }

    /**
     * 
     * @return
     *     The noticeNo
     */
    @JsonProperty("noticeNo")
    public String getNoticeNo() {
        return noticeNo;
    }

    /**
     * 
     * @param noticeNo
     *     The noticeNo
     */
    @JsonProperty("noticeNo")
    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    /**
     * 
     * @return
     *     The noticeSdt
     */
    @JsonProperty("noticeSdt")
    public Integer getNoticeSdt() {
        return noticeSdt;
    }

    /**
     * 
     * @param noticeSdt
     *     The noticeSdt
     */
    @JsonProperty("noticeSdt")
    public void setNoticeSdt(Integer noticeSdt) {
        this.noticeSdt = noticeSdt;
    }

    /**
     * 
     * @return
     *     The officetel
     */
    @JsonProperty("officetel")
    public String getOfficetel() {
        return officetel;
    }

    /**
     * 
     * @param officetel
     *     The officetel
     */
    @JsonProperty("officetel")
    public void setOfficetel(String officetel) {
        this.officetel = officetel;
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
     *     The popfile
     */
    @JsonProperty("popfile")
    public String getPopfile() {
        return popfile;
    }

    /**
     * 
     * @param popfile
     *     The popfile
     */
    @JsonProperty("popfile")
    public void setPopfile(String popfile) {
        this.popfile = popfile;
    }

    /**
     * 
     * @return
     *     The processState
     */
    @JsonProperty("processState")
    public String getProcessState() {
        return processState;
    }

    /**
     * 
     * @param processState
     *     The processState
     */
    @JsonProperty("processState")
    public void setProcessState(String processState) {
        this.processState = processState;
    }

    /**
     * 
     * @return
     *     The sexCd
     */
    @JsonProperty("sexCd")
    public String getSexCd() {
        return sexCd;
    }

    /**
     * 
     * @param sexCd
     *     The sexCd
     */
    @JsonProperty("sexCd")
    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    /**
     * 
     * @return
     *     The specialMark
     */
    @JsonProperty("specialMark")
    public String getSpecialMark() {
        return specialMark;
    }

    /**
     * 
     * @param specialMark
     *     The specialMark
     */
    @JsonProperty("specialMark")
    public void setSpecialMark(String specialMark) {
        this.specialMark = specialMark;
    }

    /**
     * 
     * @return
     *     The weight
     */
    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
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
