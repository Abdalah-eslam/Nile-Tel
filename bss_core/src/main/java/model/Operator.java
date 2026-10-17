package model;

public class Operator {
    private String username;
    private String Hashedpassword;
    private String full_name;
    private String role;
    private Character is_active;

    public Operator() {
    }

    public Operator(String username, String hashedpassword, String full_name, String role, Character is_active) {
        this.username = username;
        Hashedpassword = hashedpassword;
        this.full_name = full_name;
        this.role = role;
        this.is_active = is_active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedpassword() {
        return Hashedpassword;
    }

    public void setHashedpassword(String hashedpassword) {
        Hashedpassword = hashedpassword;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Character getIs_active() {
        return is_active;
    }

    public void setIs_active(Character is_active) {
        this.is_active = is_active;
    }
}
