public class Admin extends Person{
    private String id = "Admin";
    private String passward = "Admin1234";

    public Admin(String name, int phone){
        super(name,phone);
    }

    public String getId(){
        return id;
    }

    public String getPassward(){
        return passward;
    }
}
