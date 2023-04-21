package hotel;

public class MyException extends Exception {

    String msg;

    public MyException() {
        msg="";
    }

    MyException(String m) {
        this.msg=m;
    }

    @Override
    public String toString() {
        return msg;
    }
}
