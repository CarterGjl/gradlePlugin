package cmd.test;

public class ACUserTokenView {
    public ACUserView getUser() {
        return user;
    }

    public void setUser(ACUserView user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private ACUserView user;
    private String token;

    @Override
    public String toString() {
        return "ACUserTokenView{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
