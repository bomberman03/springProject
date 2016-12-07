package koreatech.cse.domain.ma;

/**
 * Created by RyuSiHo on 2016. 12. 7..
 */
import com.fasterxml.jackson.annotation.*;
import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "list"
})

public class MachineAnchor {
    @JsonProperty("list")
    private List<FileList> list = new ArrayList<FileList>();

    @JsonProperty("list")
    public List<FileList> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<FileList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MachineAnchor{" +
                "list=" + list +
                '}';
    }
}
