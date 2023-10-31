package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // lombok은 게터 세터를 자동으로 만들어준다, 게터세터 메소드를 구현안해도된다
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfas");
        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
