package main.java.ma.znagui.Model;

public class Client {
    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean isPro;

    public Client(){

    }
    public Client(int id, String name, String email, String phone, boolean isPro) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isPro = isPro;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsPro() {
        return isPro;
    }
    public void setIsPro(boolean isPro) {
        this.isPro = isPro;
    }

    public String toString(){
        return "Client N°: " + this.id + "--> name: " + this.name + "--> email: " + this.email + "--> phone: " + this.phone + "--> isPro: " + this.isPro + " ";

    }
}
