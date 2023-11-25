package model;


public class User {
    
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        
        this.username = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        
        return "User{" + "id=" + id + ", userName='" + username + '\'' +", password='" + password + '\'' + '}';
    }

   
}
