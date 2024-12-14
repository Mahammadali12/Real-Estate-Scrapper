package grad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import grad.model.Product;

@SpringBootApplication
public class App {

    static List<Product> products;
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        List<String[]> listings = new ArrayList<>();
        Set<String> listingsDiscovered = new HashSet<>();
        List<String> listingsToScrape = new ArrayList<>();
        products = new ArrayList<>();

        scrapeListingLinks( listings, listingsDiscovered, listingsToScrape);
        System.out.println("SCRAPED LINKS");

        while (!listings.isEmpty()) {
            scrapeListing(listings,products);            
        }

        System.out.println("Finished Scraping");

    }

    public static void scrapeListingLinks(
        List<String[]> listings,
        Set<String> listingsDiscovered,
        List<String> listingsToScrape
    ){
        // String url = paginations.remove(0);
        String url = "https://bina.az/alqi-satqi?page=";
        int i = 1;
        Document doc;
        String[] aa= new String[3];
        while (i<2) {
            try {
                doc = Jsoup 
                .connect(url+i) 
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36") 
                .header("Accept-Language", "*") 
                .get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    
            Elements listingElements = doc.select("div.items-i");
    
            for(Element listingElement : listingElements){
            String discoveredListing = String.format("https://bina.az%s", listingElement.select("a.item_link").attr("href"));
                // System.out.println(discoveredListing);

                if(!listingsDiscovered.contains(discoveredListing) && !listingsToScrape.contains(discoveredListing)){
                    listingsToScrape.add(discoveredListing);
                }

                listingsDiscovered.add(discoveredListing);

                aa = new String[3];

                aa[0]=discoveredListing;
                aa[1]=listingElement.select("div.city_when").text().split(",")[0];
                aa[2]= listingElement.select("div.location").text();
                System.out.println(aa[0]);
                System.out.println(aa[1]);
                System.out.println(aa[2]);

                listings.add(aa);
            }    
            System.out.println(aa[0]+i+"  SCRAPED");

            i++;
        }
        
    }

    public static void scrapeListing(
        List<String[]> listings,
        List<Product> products
    ){
        String[] url = listings.remove(0);

        Document doc;

        try {
            doc = Jsoup 
                .connect(url[0]) 
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36") 
                .header("Accept-Language", "*") 
                .get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Elements product_properties = doc.select("div.product-properties__i");
        Elements product_description = doc.select("div.product-description__content");
        Elements product_title = doc.select("h1.product-title");
        Elements product_sidebar = doc.select("div.product-sidebar__box");
        Elements product_images = doc.select("div.product-photos__slider-top-i");


        Product product = new Product();
        for (Element element : product_properties) {

            product.setRoomNumber(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setCategory(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setTotalFloor(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setArea(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setLandArea(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setListingType(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setDescription(product_description.text());
            product.setUrl(url[0]);
            product.setCity(url[1]);
            product.setRayon(url[2]);
            product.setListingTitle(product_title.text());
            product.setPrice(product_sidebar.select("div.product-price__i--bold").text());
            product.setListingOwner(product_sidebar.select("div.product-owner__info-name").text());
            product.setOwnerPosition(product_sidebar.select("div.product-owner__info-region").text());
            product.setNumbersOfListingOwnerHas(product_sidebar.select("a.product-ads-count").text());
            product.setCixaris(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setListingFloor(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setTotalFloor(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
            product.setRoomNumber(element.select("span.product-properties__i-value").text(),element.select("label.product-properties__i-name").text());
        }

        for(Element el : product_images){
            product.getListingImageUrls().add(el.select("img").attr("src"));
        }
        // System.out.println(product_description.text());
        System.out.println("SCRAPED ---->  "+url[0]);
        products.add(product);

    }
}

