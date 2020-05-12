package org.roy.covid19tracker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.roy.covid19tracker.model.Country;
import org.roy.covid19tracker.utility.Covid19Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class ViewController {

    public static final Logger log = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private Covid19Data covid19Data;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Country> countryList = null;
        try {
            countryList = covid19Data.fetchData();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (countryList != null) {
            sort(countryList);
            log.info("Fetch Data complete...");
            model.addAttribute("countryList", countryList);
            model.addAttribute("TOTAL_CONFIRMED", covid19Data.getTotal("cases", countryList));
            model.addAttribute("TOTAL_DEATHS", covid19Data.getTotal("deaths", countryList));
            model.addAttribute("TOTAL_RECOVERED", covid19Data.getTotal("recovered", countryList));
        } else {
            model.addAttribute("error", "Server Busy! Please try after sometime");
        }
        return "index";
    }

    private void sort(List<Country> countryList) {
        countryList.sort(Comparator.comparing(Country::getCases).reversed());
    }
}
