package functional;

public interface IColorable {
    // 2 thanh phan
    //1. hang so
    String RED = "abcxyz";
    //2. phuong thuc
    void printColor(String color);

    // Java 8
    default void draw(){ // ko bat buoc lop con phai ghi de
        System.out.println("To mau");
    }
    default void saw(){
    }

    static void erase(){ // chi thuoc ve interface; ko ke thua
        System.out.println("Xoa");
    }

    private void toStr(){// Java 9 // chi thuc ve interface; chi cho phep truy cap trong noi bo

    }

}
