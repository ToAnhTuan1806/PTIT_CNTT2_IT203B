package methodreferences;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // tham chieu cua 1 pthuc

        // duyet qua 1 ds ten hs va in ra man hinh
        List<String> names= Arrays.asList("Tuan", "Anh", "To");
        for(String name: names){
            System.out.println(name);
        }

        // cach 2: ko pho bien
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // cach 3: dung forEach
        names.forEach(s->System.out.println(s)); // lambda expression
        names.forEach(Printer::print); // thay the lambda expression

        // Cach su dung
        /*
        ClassName :: method
        objName :: method
        ClassName :: new (ham tao)
         */

        // Bien doi ds student
        List<Student> studentList= names.stream().map(Student::new).toList();
        System.out.println(studentList);

        // Loc ra sv trong ten chua chu 'H'
        for(Student student: studentList){
            if(student.getName().contains("H")){
                System.out.println(student);
            }
        }
        // dung filter
        studentList.stream().filter((student -> student.getName().contains("H")))
                .forEach(System.out::println);
    }
}
