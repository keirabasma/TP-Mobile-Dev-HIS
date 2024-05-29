package hk.myapplication;
public class Contact {
    private String name;
    private String fname;
    private String number;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }



    public Contact(String name, String fname, String number) {
        this.name = name;
        this.fname = fname;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
