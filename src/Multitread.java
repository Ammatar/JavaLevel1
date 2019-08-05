import java.util.Arrays;

public class Multitread {
    static final int size = 10000000;
    static final int halfSize = size / 2;
    private static final float[] arrOne = new float[size];
    private static final float[] arrTwo = new float[size];

    public static void main(String[] args) {
        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = 1f;
        }
        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = 1f;
        }

        long beginTime = System.nanoTime();
        calculateArray(arrOne);
        long deltaTime = System.nanoTime() - beginTime;
        System.out.println("One thread : " + deltaTime*1e-9f);

        beginTime = System.nanoTime();
        calculateArrayTwo(arrTwo);
        deltaTime = System.nanoTime() - beginTime;
        System.out.println("Multi thread : " + deltaTime*1e-9f);

        if (Arrays.equals(arrOne,arrTwo)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }

    public static void calculateArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i]* Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }
    private static void calculateArrayTwo (float[] arr) {
        final float[] a1 = new float[halfSize];
        final float[] a2 = new float[halfSize];

        System.arraycopy(arr, 0, a1,0, halfSize);
        System.arraycopy(arr, halfSize, a2, 0 , halfSize);

        CalcThread threadOne = new CalcThread(a1,0);
        CalcThread threadTwo = new CalcThread(a2,halfSize);

        try{
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(a1, 0, arr, 0, halfSize);
        System.arraycopy(a2, 0, arr, halfSize, halfSize);
    }
}
