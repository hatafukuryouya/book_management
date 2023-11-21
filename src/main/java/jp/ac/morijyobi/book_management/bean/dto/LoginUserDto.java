package jp.ac.morijyobi.book_management.bean.dto;

public class LoginUserDto {
    private int id;
    private String username;
    private String password;
    private String name;
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public LoginUserDto(int id, String username, String password, String name, String authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.authority = authority;
    }
}
