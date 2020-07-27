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
        "films",
        "tvSeries",
        "people",
        "genres",
        "profiles"
})
public class Media {

    @JsonProperty("films")
    private List<model.Film> films = null;
    @JsonProperty("tvSeries")
    private List<TvSeries> tvSeries = null;
    @JsonProperty("people")
    private List<Person> people = null;
    @JsonProperty("genres")
    private List<Genre> genres = null;
    @JsonProperty("profiles")
    private List<Profile> profiles = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("films")
    public List<model.Film> getFilms() {
        return films;
    }

    @JsonProperty("films")
    public void setFilms(List<model.Film> films) {
        this.films = films;
    }

    @JsonProperty("tvSeries")
    public List<TvSeries> getTvSeries() {
        return tvSeries;
    }

    @JsonProperty("tvSeries")
    public void setTvSeries(List<TvSeries> tvSeries) {
        this.tvSeries = tvSeries;
    }

    @JsonProperty("people")
    public List<Person> getPeople() {
        return people;
    }

    @JsonProperty("people")
    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @JsonProperty("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @JsonProperty("profiles")
    public List<Profile> getProfiles() {
        return profiles;
    }

    @JsonProperty("profiles")
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
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
