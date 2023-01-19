package Entity;

public class Login {
    private String nama, password;

    public Login(String nama, String password){
        this.nama = nama;
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }
}