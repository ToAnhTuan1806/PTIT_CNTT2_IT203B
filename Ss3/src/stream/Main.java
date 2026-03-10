package stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // dung for truyen thong
        for(Integer value: list){
            if(value==2){
                list.remove(value);
            }
        }
        System.out.println(list);

        // dung Iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next()==1){
                iterator.remove();
            }
        }
        System.out.println(list);


        // Tao Stream: ARRAY va COLLECTION
        int[] arr= {1,2,3,4,5};
        IntStream streamInt= Arrays.stream(arr);

        Stream<Integer> stream2= list.stream();

        // Thao tac trung gian: sorted, limit, distinct, filter, map,...
        IntStream stream3= streamInt.filter(value -> value%2==0);

        // Thao tac dau cuoi: sum, foreach, reduce, count, findFist, FindAny, anyMatch, allMatch, min, max, average
        OptionalDouble avg= stream3.average();
        System.out.println(avg.getAsDouble());

        // Vi du: Tao 1 list 1000 so nguyen ngau nhien tu -200 den 200
        List<Integer> randomList= Stream.generate(()-> new Random().nextInt(400)-200)
                .limit(1000)
                .toList(); // chuyen thanh list
        // 1. Loc va in cac so nguyen duong ra man hinh
        randomList.stream().filter(value -> value>0).forEach(integer -> System.out.print(integer+ ","));
        // 2. loai bo cac so trung lap
        List<Integer> distinctList= randomList.stream().distinct().toList();
        System.out.println("\ndistinct list: " + distinctList);
        // 3. Sap xep cac so theo thu tu tu lon den be
        randomList.stream().sorted(Comparator.reverseOrder()).forEach(integer -> System.out.print(integer+ ","));
        // 4. Tinh min, max
        Integer min= randomList.stream().min(Comparator.comparingInt(o -> o)).get();
        Integer max= randomList.stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println("\nmin: "+min);
        System.out.println("max: "+max);
        // 5. Tinh tong(sum) cua tat ca cac phan tu
        Integer sum= randomList.stream().reduce(0, Integer::sum);
        // 6. Kiem tra gia tri n nhap vao co ton tai trong danh sach khong
        boolean isExist= randomList.stream().anyMatch(num->num==100);
        System.out.println("100 co ton tai khong: "+isExist);
        // 7. Chuyen cac so am thanh so doi cua no
        List<Integer> mapInteger= randomList.stream().map(num-> num<0?-num:num).toList();
        System.out.println("MapInteger: "+mapInteger);



    }
}
