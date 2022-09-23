package co.com.pragma.model;

public class TokenModel {

    private String token;

    public String getToken() {
        return  token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "token='" + token + '\'' +
                '}';
    }
}
