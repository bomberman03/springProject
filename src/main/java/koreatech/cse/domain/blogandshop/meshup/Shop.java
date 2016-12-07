
package koreatech.cse.domain.blogandshop.meshup;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "channel"
})
public class Shop {

    @JsonProperty("channel")
    private Channel channel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The channel
     */
    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    /**
     *
     * @param channel
     *     The channel
     */
    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
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
        return "Shop{" +
                "channel=" + channel +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
