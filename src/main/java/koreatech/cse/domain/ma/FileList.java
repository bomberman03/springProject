package koreatech.cse.domain.ma;

/**
 * Created by RyuSiHo on 2016. 12. 7..
 */

import com.fasterxml.jackson.annotation.*;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "filename",
        "file_length",
        "download_link"
})

public class FileList {
    @JsonProperty("filename")
    private String filename;

    @JsonProperty("download_link")
    private String download_link;

    @JsonProperty("file_length")
    private long file_length;

    @JsonIgnore
    public FileList(){

    }

    @JsonIgnore
    public FileList(String filename, String download_link, long file_length) {
        this.filename = filename;
        this.file_length = file_length;
        this.download_link = download_link;
    }

    @JsonProperty("file_length")
    public long getFile_length() {
        return file_length;
    }

    @JsonProperty("file_length")
    public void setFile_length(long file_length) {
        this.file_length = file_length;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }


    @JsonProperty("download_link")
    public String getDownload_link() {
        return download_link;
    }

    @JsonProperty("download_link")
    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }

    @Override
    public String toString() {
        return "MachineAnchor{" +
                "filename='" + filename + '\'' +
                ", download_link='" + download_link + '\'' +
                '}';
    }
}
