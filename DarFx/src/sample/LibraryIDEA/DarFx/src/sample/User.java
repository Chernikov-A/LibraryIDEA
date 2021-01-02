package sample;

public class User {
    /* User table */
    private String username;
    private String password;
    private String ferstname;
    private String lastname;




    public User(String username, String password, String ferstname, String lastname) {
        this.username = username;
        this.password = password;
        this.ferstname = ferstname;
        this.lastname = lastname;
    }


    public User() {

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

    public String getFerstname() {
        return ferstname;
    }

    public void setFerstname(String ferstname) {
        this.ferstname = ferstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
