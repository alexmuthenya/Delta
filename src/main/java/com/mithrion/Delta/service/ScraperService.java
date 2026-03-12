package com.mithrion.Delta.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;


@Service
public class ScraperService {

    public Double scrapePrice(String url, String priceSelector){
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                    .get();
            // 2. Select the element containing the price
            Element priceElement = doc.selectFirst(priceSelector);
            if (priceElement != null) {
                String priceText = priceElement.text()
                        .replaceAll("[^\\d.]", ""); // Regex to keep only numbers and decimals
                return Double.parseDouble(priceText);
            }
        } catch (Exception e) {
            System.err.println("Failed to scrape URL: " + url + " - " + e.getMessage());
        }
        return null;
    }
}
