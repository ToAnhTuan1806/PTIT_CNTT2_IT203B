package functional;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        IColorable obj= new Shape();

        obj.draw();
        obj.printColor("red");
        IColorable.erase(); // chi thuoc ve interface

        // functional interface dung san
        // Consumer: nhan 1 doi tuong de xu ly va ko tra ve gi (in)
        // Predicate: ktra 1 dtg co thoa ma dkien ko (tim kiem)
        // Function: chuyen doi du lieu tu kieu nay sang kieu khac
        // Supplier: tu dong tao gia tri dua tren giai thuat

        // lambda expression: cu phap viet gon cua 1 method dung de
        IFunctional lb= (a, b) -> {return;};

        // Truoc Java 8: tao 1 Class roi goi Constructer
//        IFunctional i1= new Cat();
//        IFunctional i2= new IFunctional() { // lop ko ten
//            @Override
//            public void save() {
//
//            }
//        };

        Comparator<Cat> com1= (c1, c2)->-1;
        Comparator<Cat> com2= (c1, c2)->1;
        Collections.sort(new ArrayList<Cat>(), com1);

        int[] arr= {1,2,3,4,5};
        Arrays.stream(arr).map(value -> value*value)
                .forEach(t-> System.out.println(t));
    }
}
