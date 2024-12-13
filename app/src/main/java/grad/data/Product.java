package grad.data;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String url; 
    private String price;
    private String category; 
    private String locationName;
    // private String Latitute;
    private String listingTitle; 
    private String listingOwner; 
    private String ownerPosition;
    private String listingType;
    private String numbersOfListingOwnerHas; 
    private String description; 
    private List<String> listingImageUrls; 
    private String city; //TODO
    private String rayon; // TODO
    private String area; 
    private String landArea;
    private String cixaris;
    private String roomNumber;
    private String totalFloor;
    private String listingFloor;

    public Product(){
        this.listingImageUrls = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "{ \"url\":\"" + url + "\", " 
				+ " \"image\": \"" +listingImageUrls  + "\", " 
				+ "\"name\":\"" + listingTitle + "\", " 
				+ "\"price\": \"" + price + "\" }";
    }



    public String getUrl() {
        return url;
    }



    public void setUrl(String url) {
        this.url = url;
    }



    public String getPrice() {
        return price;
    }



    public void setPrice(String price) {
        this.price = price;
    }



    public String getLocationName() {
        return locationName;
    }



    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }



    public String getListingTitle() {
        return listingTitle;
    }



    public void setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
    }



    public String getListingOwner() {
        return listingOwner;
    }



    public void setListingOwner(String listingOwner) {
        this.listingOwner = listingOwner;
    }



    public String getListingType() {
        return listingType;
    }



    public void setListingType(String listingType,String label) {
        if (label.equals("Binanın növü")) {
            this.listingType = listingType;            
        }else
        System.out.println("This is not listing type");
    }




    public String getNumbersOfListingOwnerHas() {
        return numbersOfListingOwnerHas;
    }



    public void setNumbersOfListingOwnerHas(String numbersOfListingOwnerHas) {
        this.numbersOfListingOwnerHas = numbersOfListingOwnerHas;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public List<String> getListingImageUrls() {
        return listingImageUrls;
    }



    public void setListingImageUrls(List<String> listingImageUrls) {
        this.listingImageUrls = listingImageUrls;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public String getRayon() {
        return rayon;
    }



    public void setRayon(String rayon) {
        this.rayon = rayon;
    }



    public String getArea() {
        return area;
    }



    public void setArea(String area,String label) {
        if (label.equals("Sahə")) {
            this.area = area;            
        }
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea,String label) {
        if (label.equals("Torpaq sahəsi")) {
            this.landArea=landArea;
        }
    }

    public String getCixaris() {
        return cixaris;
    }

    public void setCixaris(String cixaris, String label) {
        if(label.equals("Çıxarış")){
            this.cixaris = cixaris;
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber, String label) {
        if(label.equals("Otaq sayı")){
        this.roomNumber = roomNumber;
        }
    }

    public String getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(String totalFloor, String label) {
        if (label.equals("Mərtəbə")) {
            this.totalFloor = totalFloor.substring(totalFloor.length()-2, totalFloor.length());
        }
    }

    public String getListingFloor() {
        return listingFloor;
    }

    public void setListingFloor(String listingFloor, String label) {
        if (label.equals("Mərtəbə")) {
            this.listingFloor= listingFloor;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category,String label){
        if(label.equals("Kateqoriya")){
            this.category=category;
        }
    }



    public String getOwnerPosition() {
        return ownerPosition;
    }

    public void setOwnerPosition(String ownerPosition){
        this.ownerPosition = ownerPosition;
    }
    
}
