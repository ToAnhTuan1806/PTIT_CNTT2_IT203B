package baitap;

public class UserValidator {
    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        //ktr do dai
        if(username.length()<6|| username.length()>20){
            return false;
        }
        //ktr co khoang trang
        if(username.contains(" ")){
            return false;
        }
        return true;
    }
}
