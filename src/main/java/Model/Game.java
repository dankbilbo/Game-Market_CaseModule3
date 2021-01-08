package Model;


import java.time.LocalDate;
import java.util.Date;

public class Game {
    private int id;
    private String appType;
    private String name;
    private String developer;
    private String publisher;
    private LocalDate releasedDate;
    private Double price;
    private int discount;
    private int numberUserOwned;

    public Game() {
    }

    public Game(int id, String appType, String name, String developer, String publisher, LocalDate releasedDate, Double price, int discount) {
        this.id = id;
        this.appType = appType;
        this.name = name;
        this.developer = developer;
        this.publisher = publisher;
        this.releasedDate = releasedDate;
        this.price = price;
        this.discount = discount;
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

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
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
}
