package streamapi;

import com.opencsv.CSVWriter;
import dirandfile.DirUtilException;
import dirandfile.DirUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApi {
    public static void main(String[] args) throws IOException, DirUtilException {
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
        System.out.println("все кроме Иваныча ->" + peopleList.stream().filter(workPeople -> ((workPeople.sex.equals(Sex.MAN) && (workPeople.age < 60))) || ((workPeople.sex.equals(Sex.WOMEN)) && (workPeople.age < 55))).toList());

        // -------------------------------------дз вторая часть----------------------------------------------------

        String rootPath = "C:\\Users\\Burning\\IdeaProjects\\NY\\src\\main\\java\\";
        //создал папку
        DirUtils.createDirectory(rootPath, "output");
        //создал файл
        DirUtils.createFile(rootPath + "\\output\\", "result.csv");


        List<String[]> list = new ArrayList<>();

        peopleList.forEach(elements -> {
            String name = elements.getName();
            int age = elements.getAge();
            Sex sex = elements.getSex();
            String[] pepList = {name, Integer.toString(age), sex.toString()};
            list.add(pepList);
        });

        try (
                CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Burning\\IdeaProjects\\NY\\src\\main\\java\\output\\result.csv"))) {
            writer.writeAll(list);
        }
        //Скачиваем картинку
        String linkForIMG = "https://memepedia.ru/wp-content/uploads/2020/07/strimer-blekfejs-1.jpg";
        DirUtils.downloadImage(linkForIMG, rootPath + "\\output");
    }


}

