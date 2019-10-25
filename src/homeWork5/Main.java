package homeWork5;

import java.util.Arrays;

public class Main {

    private final static Object lock = new Object();

    static final int SIZE = 10000000; //
    static final int HALF_SIZE = SIZE / 2;


    static float[] mainArray = new float[SIZE];


    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    private static void methodOne() {

        Arrays.fill(mainArray, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < mainArray.length; i++) {
            mainArray[i] = (float) (mainArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("method one: " + (System.currentTimeMillis() - a));

    }

    private static void methodTwo() {
        long startPoint;

        Arrays.fill(mainArray, 1);

        float[] firstArr = new float[HALF_SIZE];
        float[] secondArr = new float[HALF_SIZE];


        startPoint = System.currentTimeMillis();

        System.arraycopy(mainArray, 0, firstArr, 0, firstArr.length);
        System.arraycopy(mainArray, firstArr.length, secondArr, 0, secondArr.length);

        System.out.println("разбивка массива " + (System.currentTimeMillis() - startPoint));


        startPoint = System.currentTimeMillis();

        Thread firstMath = new Thread(new MathWithThread(firstArr, 0, startPoint), "first thread");
        firstMath.start();

        startPoint = System.currentTimeMillis();

        Thread secondThread = new Thread(new MathWithThread(secondArr, HALF_SIZE, startPoint), "second thread");
        secondThread.start();

    }

    public static class MathWithThread extends Thread {
        private float[] arr;

        private int indexMath;
        private long startPoint;

        public MathWithThread(float[] arr, int indexMath, long startPoint) {
            this.arr = arr;
            this.indexMath = indexMath;
            this.startPoint = startPoint;
        }

        @Override
        public void run() {
            for (int i = 0, k = indexMath; i < arr.length; i++, k++) {

                arr[i] = (float) (arr[i] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));


            }
            synchronized (lock) {   // добавим работу через синхронизацию объекта.

                System.arraycopy(arr, 0, Main.mainArray, indexMath, arr.length);
            }
            System.out.println(Thread.currentThread().getName() + " " + (System.currentTimeMillis() - startPoint));
        }
    }


}
