package org.roy.covid19tracker.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.roy.covid19tracker.model.Country;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Service
public class Covid19Data {

    public static final String URL = "https://corona.lmao.ninja/v2/countries?yesterday&sort";

    private final JsonParser jsonParser = new JsonParser();

    public List<Country> fetchData() throws JsonProcessingException {
        String convertedData = "";
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return null;
            }
            convertedData = convertData(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonParser.getCountryData(convertedData);
    }

    private String convertData(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();
        return sb.toString();
    }

    public long getTotal(String col, List<Country> countryList) {
        long total = 0;
        for (Country country : countryList) {
            if (col.equalsIgnoreCase("cases")) {
                total += country.getCases();
            } else if (col.equalsIgnoreCase("deaths")) {
                total += country.getDeaths();
            } else if (col.equalsIgnoreCase("recovered")) {
                total += country.getRecovered();
            }
        }
        return total;
    }
}
