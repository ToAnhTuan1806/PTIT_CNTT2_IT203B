package datetime;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // truoc Java 8
        Date date= new Date(); // tra ve thoi gian cua he thong theo mili giay
        System.out.println("miliSeconds: "+date.getTime());
        System.out.println(date);

        // tao 1 ngay 18-06-2006


        // DateTimeAPI 4 kieu:
        LocalDate today = LocalDate.now();
        LocalTime time= LocalTime.now();
        LocalDateTime dateTime= LocalDateTime.now();
        ZonedDateTime zonedDateTime= ZonedDateTime.now(); // mui gio
        System.out.println("today: "+today);
        System.out.println("time: "+time);
        System.out.println("dateTime: "+dateTime);
        System.out.println("zonedDateTime: "+zonedDateTime);

        LocalDate bornIn = LocalDate.of(2006, 6, 18);
        Period age= Period.between(bornIn, today);
        System.out.println("age: "+age);




        // Optional
        Optional<Integer> op1= Optional.empty();
        Optional<Integer> op2= Optional.of(1);
        Optional<Integer> op3= Optional.ofNullable(2);

        if(op3.isPresent()) {
            // co gia tri khac null
            // lay ra gia tri
            System.out.println(op3.get());
        }

        // lay truc tiep gia tri neu no ton tai hoac 1 gia tri chi dinh
        Integer value=op3.orElse(100);

        // lay truc tiep gia tri hoac nem ngoai le
        Integer val= op3.orElseThrow(()-> new RuntimeException("Loi gi do"));


    }

}
