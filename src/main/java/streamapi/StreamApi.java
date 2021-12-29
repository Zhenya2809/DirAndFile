package streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamApi {
    public static void main(String[] args) {

        List<People> peopleList = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Иван", 14, Sex.MAN),
                new People("Иван Иванович", 69, Sex.MAN),
                new People("Елена", 23, Sex.WOMEN),
                new People("Юлия", 28, Sex.WOMEN),
                new People("Виктория", 37, Sex.WOMEN),
                new People("Анна", 25, Sex.WOMEN));
        System.out.println("служить пойдут -> " + peopleList.stream().filter(army -> (army.age > 18) && (army.age < 27)).toList());
        System.out.println("средний возраст-> " + peopleList.stream().filter(sex -> sex.sex.equals(Sex.MAN)).mapToInt(x -> x.age).average());
        System.out.println("все кроме Иваныча ->"+peopleList.stream().filter(workPeople -> ((workPeople.sex.equals(Sex.MAN) && (workPeople.age < 60))) || ((workPeople.sex.equals(Sex.WOMEN)) && (workPeople.age < 55))).toList());
    }
}
