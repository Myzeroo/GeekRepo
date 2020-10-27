package HomeWork_2_02;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Требуется массив 4*4");
    }

    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
