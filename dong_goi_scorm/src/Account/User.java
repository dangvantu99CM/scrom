package Account;

public class User {
    private UserData data = new UserData();

    public User(int id,String name,String password,String address,int phone,String email,int gender,String name_login) {
        this.data.name=name;
        this.data.password=password;
        this.data.id=id;
        this.data.phone=phone;
        this.data.address=address;
        this.data.email=email;
        this.data.gender=gender;
        this.data.name_login=name_login;
    }
    
    public User(String name,String password,String address,int phone,String email,int gender,String name_login) {
        this.data.name=name;
        this.data.password=password;
        this.data.phone=phone;
        this.data.address=address;
        this.data.email=email;
        this.data.gender=gender;
        this.data.name_login=name_login;
    }

    public String getName() {
            return data.name;
    }
    
    public int getGender() {
            return data.gender;
    }

    public String getNameLogin() {
            return data.name_login;
    }

    public String getPassword() {
            return data.password;
    }

    public int getId() {
            return data.id;
    }

    public int getPhone() {
            return data.phone;
    }

    public String getAddress() {
            return data.address;
    }

    public String getEmail() {
            return data.email;
    }

    public void setPassword(String password) {
            this.data.password = password;
    }

    public void setName(String name) {
            this.data.name = name;
    }

    public void setId(int id) {
            this.data.id = id;
    }
    
    public void setGender(int gender) {
            this.data.gender = gender;
    }

    public void setEmail(String email) {
            this.data.email = email;
    }

    public void setPhone(int phone) {
            this.data.phone = phone;
    }

    public void setAddess(String address) {
            this.data.address = address;
    }

    public void setNameLogin(String nameLogin) {
            this.data.name_login = nameLogin;
    }

}
