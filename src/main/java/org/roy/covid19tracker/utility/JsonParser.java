package org.roy.covid19tracker.utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.roy.covid19tracker.model.Country;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List<Country> getCountryData(String data) {
        List<Country> countryList = new ArrayList<>();

        JSONObject parentObject = new JSONObject(data);

        JSONObject global = (JSONObject) parentObject.get("Global");
        GlobalData.NEW_CONFIRMED = (int) global.get("NewConfirmed");
        GlobalData.TOTAL_CONFIRMED = (int) global.get("TotalConfirmed");
        GlobalData.NEW_DEATHS = (int) global.get("NewDeaths");
        GlobalData.TOTAL_DEATHS = (int) global.get("TotalDeaths");
        GlobalData.NEW_RECOVERED = (int) global.get("NewRecovered");
        GlobalData.TOTAL_RECOVERED = (int) global.get("TotalRecovered");

        JSONArray countries = (JSONArray) parentObject.get("Countries");
        for (int i = 0; i < countries.length(); i++) {
            JSONObject countryObj = (JSONObject) countries.get(i);
            Country country = new Country();
            country.setCountry((String) countryObj.get("Country"));
            country.setCountryCode((String) countryObj.get("CountryCode"));
            country.setSlug((String) countryObj.get("Slug"));
            country.setNewConfirmed(Integer.parseInt(countryObj.get("NewConfirmed").toString()));
            country.setTotalConfirmed(Integer.parseInt(countryObj.get("TotalConfirmed").toString()));
            country.setNewDeaths(Integer.parseInt(countryObj.get("NewDeaths").toString()));
            country.setTotalDeaths(Integer.parseInt(countryObj.get("TotalDeaths").toString()));
            country.setNewRecovered(Integer.parseInt(countryObj.get("NewRecovered").toString()));
            country.setTotalRecovered(Integer.parseInt(countryObj.get("TotalRecovered").toString()));
            country.setDate((String) countryObj.get("Date"));
            countryList.add(country);
        }
        return countryList;
    }
}
