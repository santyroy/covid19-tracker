package org.roy.covid19tracker.controller;

import org.roy.covid19tracker.model.Country;
import org.roy.covid19tracker.utility.Covid19Data;
import org.roy.covid19tracker.utility.GlobalData;
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
        List<Country> countryList = covid19Data.fetchData();
        if (countryList != null) {
            sort(countryList);
            log.info("Fetch Data complete...");
            model.addAttribute("countryList", countryList);
            model.addAttribute("NEW_CONFIRMED", GlobalData.NEW_CONFIRMED);
            model.addAttribute("TOTAL_CONFIRMED", GlobalData.TOTAL_CONFIRMED);
            model.addAttribute("NEW_DEATHS", GlobalData.NEW_DEATHS);
            model.addAttribute("TOTAL_DEATHS", GlobalData.TOTAL_DEATHS);
            model.addAttribute("NEW_RECOVERED", GlobalData.NEW_RECOVERED);
            model.addAttribute("TOTAL_RECOVERED", GlobalData.TOTAL_RECOVERED);
        } else {
            model.addAttribute("error", "Server Busy! Please try after sometime");
        }
        return "index";
    }

    private void sort(List<Country> countryList) {
        countryList.sort(Comparator.comparing(Country::getTotalConfirmed).reversed());
    }
}
