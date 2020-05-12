package org.roy.covid19tracker.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "updated",
        "country",
        "countryInfo",
        "cases",
        "todayCases",
        "deaths",
        "todayDeaths",
        "recovered",
        "active",
        "critical",
        "casesPerOneMillion",
        "deathsPerOneMillion",
        "tests",
        "testsPerOneMillion",
        "continent"
})
public class Country {

    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("country")
    private String country;
    @JsonProperty("countryInfo")
    private CountryInfo countryInfo;
    @JsonProperty("cases")
    private Integer cases;
    @JsonProperty("todayCases")
    private Integer todayCases;
    @JsonProperty("deaths")
    private Integer deaths;
    @JsonProperty("todayDeaths")
    private Integer todayDeaths;
    @JsonProperty("recovered")
    private Integer recovered;
    @JsonProperty("active")
    private Integer active;
    @JsonProperty("critical")
    private Integer critical;
    @JsonProperty("casesPerOneMillion")
    private Integer casesPerOneMillion;
    @JsonProperty("deathsPerOneMillion")
    private Integer deathsPerOneMillion;
    @JsonProperty("tests")
    private Integer tests;
    @JsonProperty("testsPerOneMillion")
    private Integer testsPerOneMillion;
    @JsonProperty("continent")
    private String continent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("updated")
    public Long getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("countryInfo")
    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    @JsonProperty("countryInfo")
    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    @JsonProperty("cases")
    public Integer getCases() {
        return cases;
    }

    @JsonProperty("cases")
    public void setCases(Integer cases) {
        this.cases = cases;
    }

    @JsonProperty("todayCases")
    public Integer getTodayCases() {
        return todayCases;
    }

    @JsonProperty("todayCases")
    public void setTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
    }

    @JsonProperty("deaths")
    public Integer getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    @JsonProperty("todayDeaths")
    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    @JsonProperty("todayDeaths")
    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    @JsonProperty("recovered")
    public Integer getRecovered() {
        return recovered;
    }

    @JsonProperty("recovered")
    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    @JsonProperty("active")
    public Integer getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Integer active) {
        this.active = active;
    }

    @JsonProperty("critical")
    public Integer getCritical() {
        return critical;
    }

    @JsonProperty("critical")
    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    @JsonProperty("casesPerOneMillion")
    public Integer getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    @JsonProperty("casesPerOneMillion")
    public void setCasesPerOneMillion(Integer casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    @JsonProperty("deathsPerOneMillion")
    public Integer getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    @JsonProperty("deathsPerOneMillion")
    public void setDeathsPerOneMillion(Integer deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    @JsonProperty("tests")
    public Integer getTests() {
        return tests;
    }

    @JsonProperty("tests")
    public void setTests(Integer tests) {
        this.tests = tests;
    }

    @JsonProperty("testsPerOneMillion")
    public Integer getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    @JsonProperty("testsPerOneMillion")
    public void setTestsPerOneMillion(Integer testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    @JsonProperty("continent")
    public String getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(String continent) {
        this.continent = continent;
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

