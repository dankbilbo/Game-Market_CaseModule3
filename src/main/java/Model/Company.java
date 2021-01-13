package Model;

public class Company {
    private int id;
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Company() {
    }

    public Company(int id,String name) {
        this.name = name;
        this.id = id;

    }
    public Company(int id, String name, String url){
        this.id = id;
        this.name = name;
        this.url = url;
    }

}
