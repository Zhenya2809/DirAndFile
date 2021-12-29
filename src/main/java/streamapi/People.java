package streamapi;


import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class People {

    String name;
    int age;
    Sex sex;
}
