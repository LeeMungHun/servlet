package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;
//롬복 덕분에 아래와 같이 가능
@Getter @Setter
public class HelloData {

    private String username;
    private int age;
/**
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
}
