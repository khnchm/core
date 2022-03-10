package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HolloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HolloLombok holloLombok = new HolloLombok();
        holloLombok.setName("asdfasdf");

        System.out.println("holloLombok = " + holloLombok);
        
        
    }
}
