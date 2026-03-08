import java.io.IOException;

public class Ex4 {
    //method C
    public static void saveToFile() throws IOException {
        throw new IOException("Loi khi ghi du lieu vao file");
    }

    //method B
    public static void processUserData() throws IOException {
        System.out.println("Dang xu ly du lieu nguoi dung");
        saveToFile();
    }

    //method A
    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Da xay ra loi: " + e.getMessage());
        }
    }
}
