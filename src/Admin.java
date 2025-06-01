public class Admin extends Person{
    private String id = "admin";
    private String password = "admin123";

    public Admin(String name, String phone) {
        super(name, phone);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
