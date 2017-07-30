
package com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest;

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
    "description",
    "id",
    "matched_substrings",
    "place_id",
    "reference",
    "structured_formatting",
    "terms",
    "types"
})
public class Prediction {

    @JsonProperty("description")
    public String description;
    @JsonProperty("id")
    public String id;
    @JsonProperty("matched_substrings")
    public List<MatchedSubstring> matchedSubstrings = null;
    @JsonProperty("place_id")
    public String placeId;
    @JsonProperty("reference")
    public String reference;
    @JsonProperty("structured_formatting")
    public StructuredFormatting structuredFormatting;
    @JsonProperty("terms")
    public List<Term> terms = null;
    @JsonProperty("types")
    public List<String> types = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
