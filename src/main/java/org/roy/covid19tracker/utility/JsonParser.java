package org.roy.covid19tracker.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.roy.covid19tracker.model.Country;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List<Country> getCountryData(String data) throws JsonProcessingException {
        List<Country> countryList = new ArrayList<>();

        JSONArray parentArray = new JSONArray(data);
        for (int i = 0; i < parentArray.length(); i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            Country country = objectMapper.readValue(parentArray.get(i).toString(), Country.class);
            countryList.add(country);
        }
        return countryList;
    }
}
