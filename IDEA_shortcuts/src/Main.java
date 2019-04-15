import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Look");
        System.out.println("new");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");


        for (String s : strings) {
            System.out.println(s);
        }


    }


}
