package org.roy.covid19tracker.utility;

import org.roy.covid19tracker.model.Country;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Service
public class Covid19Data {

    public static final String URL = "https://api.covid19api.com/summary";
    public static StringBuilder data = new StringBuilder();

    private final JsonParser jsonParser = new JsonParser();

    public List<Country> fetchData() {
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                if (responseCode == 429) {
                    return null;
                }
                return null;
            }
            data.append(convertData(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonParser.getCountryData(data.toString());
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
}
