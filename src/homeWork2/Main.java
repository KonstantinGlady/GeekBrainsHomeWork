package homeWork2;

import java.nio.channels.ScatteringByteChannel;

//TODO 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//TODO 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.


//TODO 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
// и вывести результат расчета.

public class Main {
    public static void main(String[] args) {

       // String[][] arr = {{"3", "2", "2", "2"}, {"7", "2", "8", "3"}, {"3", "1", "7", "3"}, {"4", "2", "9", "5"}};
        String[][] arr = {{"3", "2", "3", "2"}, {"7", "2", "8", "3"}, {"3", "1", "7", "3"}, {"4", "2", "9", "5"},{"3", "2", "3", "2"}};

        try {
            workWithArray(arr);

        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }


    }

    private static void workWithArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) { //внутренние массивы могут быть разного размера. если нужно проверить внутренние массивы то добавим:  && arr[0].length != 4 и тд
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    sum += Integer.parseInt(arr[i][j]);

                } catch (NumberFormatException e) {

                    throw new MyArrayDataException(i, j);
                }


            }
        }

        System.out.println(" Sum of numbers array is " + sum);
    }


}
