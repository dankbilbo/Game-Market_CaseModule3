package Model;


import java.time.LocalDate;
import java.util.Date;

public class Game {
    private int id;
    private String appType;
    private String name;
    private Company developer;
    private Company publisher;
    private Date releasedDate;
    private Double price;
    private String logoURL;
    private String imgURL;
    private int discount;
    private int numberUserOwned;
    private int numberUserFollowed;
    private int numberLiked;
    private int numberWished;

    public Game() {
    }

    public Game(int id, String appType, String name, Company developer, Company publisher, Date releasedDate, Double price, int discount,String logoURL, String imgURL) {
        this.id = id;
        this.appType = appType;
        this.name = name;
        this.developer = developer;
        this.publisher = publisher;
        this.releasedDate = releasedDate;
        this.price = price;
        this.discount = discount;
        this.logoURL = logoURL;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getDeveloper() {
        return developer;
    }

    public void setDeveloper(Company developer) {
        this.developer = developer;
    }

    public Company getPublisher() {
        return publisher;
    }

    public void setPublisher(Company publisher) {
        this.publisher = publisher;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getNumberUserOwned() {
        return numberUserOwned;
    }

    public void setNumberUserOwned(int numberUserOwned) {
        this.numberUserOwned = numberUserOwned;
    }

    public int getNumberUserFollowed() {
        return numberUserFollowed;
    }

    public void setNumberUserFollowed(int numberUserFollowed) {
        this.numberUserFollowed = numberUserFollowed;
    }

    public int getNumberLiked() {
        return numberLiked;
    }

    public void setNumberLiked(int numberLiked) {
        this.numberLiked = numberLiked;
    }

    public int getNumberWished() {
        return numberWished;
    }

    public void setNumberWished(int numberWished) {
        this.numberWished = numberWished;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
