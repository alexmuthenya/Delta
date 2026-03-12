package com.mithrion.Delta.controller;

import com.mithrion.Delta.service.ScraperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    private final ScraperService scraperService;
    public TestController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }
    @GetMapping("/scrape")
    public ResponseEntity<Double> testScrape(@RequestParam String url) {
        String priceSelector = "span.-b.-ubpt.-tal.-fs24.-prxs";
        Double price = scraperService.scrapePrice(url, priceSelector);
        return ResponseEntity.ok(price);
    }
}
