package org.roy.covid19tracker.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.roy.covid19tracker.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
public class Covid19Data {

    public static final String URL = "https://corona.lmao.ninja/v2/countries?yesterday&sort";
    private final JsonParser jsonParser = new JsonParser();
    private static final Logger log = LoggerFactory.getLogger(Covid19Data.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000 * 60 * 30)
    public void fetchData() throws JsonProcessingException {
        log.info("Data Fetching started....");
        String convertedData = "";
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                convertedData = convertData(url);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        GlobalData.countries = new ArrayList<>();
        GlobalData.countries = jsonParser.getCountryData(convertedData);
        log.info("DATA SIZE: "+String.valueOf(GlobalData.countries.size()));
        log.info("Data Fetching completed...." + dateFormat.format(new Date()));
//        return jsonParser.getCountryData(convertedData);
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
