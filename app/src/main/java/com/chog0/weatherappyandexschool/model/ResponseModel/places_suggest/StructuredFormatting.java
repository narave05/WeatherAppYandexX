
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
    "main_text",
    "main_text_matched_substrings",
    "secondary_text"
})
public class StructuredFormatting {

    @JsonProperty("main_text")
    public String mainText;
    @JsonProperty("main_text_matched_substrings")
    public List<MainTextMatchedSubstring> mainTextMatchedSubstrings = null;
    @JsonProperty("secondary_text")
    public String secondaryText;
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
