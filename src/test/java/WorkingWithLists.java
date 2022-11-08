import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    @Test
    public void createAndWorkWithLists() {
        Student valera = new Student();
        valera.setFistName("Valera");
        valera.setLastName("The Tester");
        valera.setEmail("valera@test.lv");
        valera.setPhone("+371232323");

        Student liga = new Student("Liga", "Ivanova", "liga@test.lv", "+37195746546");
        Student ivars = new Student("Ivars", "Zutis", "lolkek@gmail.com", "+37223454343");
        Student kristaps = new Student("Kristaps", "Lidaka", "", "+3732557483");

        List<Student> students = new ArrayList<>();
        students.add(valera); //0 индекс
        students.add(ivars); //1 индекс
        students.add(kristaps); //2 индекс
        students.add(liga); //3 индекс


        //-------------FOR-------------
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getFistName());

        }

        //-----------------FOREACH-------------------

        for (Student s : students) {
            //System.out.println(s.getFistName() + " " + s.getLastName());
            System.out.println(s.getFullName());
        }
        //------------------ for each with if statement
        System.out.println("Printing students with +371: phone:");
        for (Student s : students) {

            if (s.getPhone().startsWith("+371")) {
                System.out.println(s.getFullName());
            }
        }
    }
}
