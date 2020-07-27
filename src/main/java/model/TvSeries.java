package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tid",
        "title",
        "year",
        "genre",
        "creator",
        "cast",
        "description"
})
public class TvSeries {

    @JsonProperty("tid")
    private Integer tid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("genre")
    private List<Integer> genre = null;
    @JsonProperty("creator")
    private Integer creator;
    @JsonProperty("cast")
    private List<Integer> cast = null;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tid")
    public Integer getTid() {
        return tid;
    }

    @JsonProperty("tid")
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("genre")
    public List<Integer> getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(List<Integer> genre) {
        this.genre = genre;
    }

    @JsonProperty("creator")
    public Integer getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @JsonProperty("cast")
    public List<Integer> getCast() {
        return cast;
    }

    @JsonProperty("cast")
    public void setCast(List<Integer> cast) {
        this.cast = cast;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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