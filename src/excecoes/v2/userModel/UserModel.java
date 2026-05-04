package excecoes.v2.userModel;

import java.time.LocalDate;

public class UserModel {

    private long id;
    private String name;
    private String email;
    private LocalDate birthday;

    public UserModel(long id, String name, String email, LocalDate birthday){
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    @Override
    public String toString(){
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
