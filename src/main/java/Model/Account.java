package Model;

public class Account {
    private String username;
    private String password;
    private String email;
    private String country;
    private String bankAccountNumber;

    public Account() {
    }

    public Account(String username, String password, String email, String country, String bankAccountNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}