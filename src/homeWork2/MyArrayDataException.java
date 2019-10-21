package homeWork2;
//NumberFormatException
public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(int i, int j) {super("Данные некоректного типа, координаты элемента в массиве: " + i + " "+j); }

}
