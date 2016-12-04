
package koreatech.cse.domain.blogandshop.daum.shop;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "publish_date",
    "review_count",
    "link",
    "maker",
    "product_type",
    "price_group",
    "docid",
    "title",
    "category_name",
    "shoppingmall_count",
    "image_url",
    "description",
    "price_min",
    "brand",
    "price_max",
    "shoppingmall"
})
public class Item {

    @JsonProperty("publish_date")
    private String publishDate;
    @JsonProperty("review_count")
    private String reviewCount;
    @JsonProperty("link")
    private String link;
    @JsonProperty("maker")
    private String maker;
    @JsonProperty("product_type")
    private String productType;
    @JsonProperty("price_group")
    private String priceGroup;
    @JsonProperty("docid")
    private String docid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("category_name")
    private String categoryName;
    @JsonProperty("shoppingmall_count")
    private String shoppingmallCount;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price_min")
    private String priceMin;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("price_max")
    private String priceMax;
    @JsonProperty("shoppingmall")
    private String shoppingmall;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The publishDate
     */
    @JsonProperty("publish_date")
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * 
     * @param publishDate
     *     The publish_date
     */
    @JsonProperty("publish_date")
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 
     * @return
     *     The reviewCount
     */
    @JsonProperty("review_count")
    public String getReviewCount() {
        return reviewCount;
    }

    /**
     * 
     * @param reviewCount
     *     The review_count
     */
    @JsonProperty("review_count")
    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    /**
     * 
     * @return
     *     The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The maker
     */
    @JsonProperty("maker")
    public String getMaker() {
        return maker;
    }

    /**
     * 
     * @param maker
     *     The maker
     */
    @JsonProperty("maker")
    public void setMaker(String maker) {
        this.maker = maker;
    }

    /**
     * 
     * @return
     *     The productType
     */
    @JsonProperty("product_type")
    public String getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType
     *     The product_type
     */
    @JsonProperty("product_type")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return
     *     The priceGroup
     */
    @JsonProperty("price_group")
    public String getPriceGroup() {
        return priceGroup;
    }

    /**
     * 
     * @param priceGroup
     *     The price_group
     */
    @JsonProperty("price_group")
    public void setPriceGroup(String priceGroup) {
        this.priceGroup = priceGroup;
    }

    /**
     * 
     * @return
     *     The docid
     */
    @JsonProperty("docid")
    public String getDocid() {
        return docid;
    }

    /**
     * 
     * @param docid
     *     The docid
     */
    @JsonProperty("docid")
    public void setDocid(String docid) {
        this.docid = docid;
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
     *     The categoryName
     */
    @JsonProperty("category_name")
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName
     *     The category_name
     */
    @JsonProperty("category_name")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 
     * @return
     *     The shoppingmallCount
     */
    @JsonProperty("shoppingmall_count")
    public String getShoppingmallCount() {
        return shoppingmallCount;
    }

    /**
     * 
     * @param shoppingmallCount
     *     The shoppingmall_count
     */
    @JsonProperty("shoppingmall_count")
    public void setShoppingmallCount(String shoppingmallCount) {
        this.shoppingmallCount = shoppingmallCount;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The priceMin
     */
    @JsonProperty("price_min")
    public String getPriceMin() {
        return priceMin;
    }

    /**
     * 
     * @param priceMin
     *     The price_min
     */
    @JsonProperty("price_min")
    public void setPriceMin(String priceMin) {
        this.priceMin = priceMin;
    }

    /**
     * 
     * @return
     *     The brand
     */
    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand
     *     The brand
     */
    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 
     * @return
     *     The priceMax
     */
    @JsonProperty("price_max")
    public String getPriceMax() {
        return priceMax;
    }

    /**
     * 
     * @param priceMax
     *     The price_max
     */
    @JsonProperty("price_max")
    public void setPriceMax(String priceMax) {
        this.priceMax = priceMax;
    }

    /**
     * 
     * @return
     *     The shoppingmall
     */
    @JsonProperty("shoppingmall")
    public String getShoppingmall() {
        return shoppingmall;
    }

    /**
     * 
     * @param shoppingmall
     *     The shoppingmall
     */
    @JsonProperty("shoppingmall")
    public void setShoppingmall(String shoppingmall) {
        this.shoppingmall = shoppingmall;
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
        return "Item{" +
                "publishDate='" + publishDate + '\'' +
                ", reviewCount='" + reviewCount + '\'' +
                ", link='" + link + '\'' +
                ", maker='" + maker + '\'' +
                ", productType='" + productType + '\'' +
                ", priceGroup='" + priceGroup + '\'' +
                ", docid='" + docid + '\'' +
                ", title='" + title + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", shoppingmallCount='" + shoppingmallCount + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", priceMin='" + priceMin + '\'' +
                ", brand='" + brand + '\'' +
                ", priceMax='" + priceMax + '\'' +
                ", shoppingmall='" + shoppingmall + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
