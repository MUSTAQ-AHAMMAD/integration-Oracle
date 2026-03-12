package innovate.tamergroup.shared.utils;

import java.util.Base64;

public class Credential {
    
    private String username;
    private String password;
    private String token;


    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Credential(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return token == null ? Base64.getEncoder().encodeToString((username + ":" + password).getBytes()) : token;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
