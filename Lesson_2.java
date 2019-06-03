/**
 * Артур Резник, Java. Уровень 1 урок 2, 04.06.2019
 */
import java.util.Arrays;

public class Lesson_2 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        minMaxArray();
        arrayMidlle();
    }
    public static void invertArray(){
        int[] arr = { 1, 0, 1, 0, 0, 1 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------");
    }
    public static void fillArray(){
        int[] arr = new int[8];
        int startPoint = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = startPoint;
            startPoint += 3;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------");
    }
    public static void changeArray(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------");
    }
    public static void fillDiagonal() {
        int[][] arr = new int[2][2];
        for (int i = 0; i < arr.length; i++){
            for (int p = 0; p < arr[i].length; p++){
                if (i == p) {
                    arr[i][p] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println("---------------------------");
    }
    public static void minMaxArray(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("В массиве чисел: " + Arrays.toString(arr) + " минимальным элементом является " + min + " , а максимальным " + max);
        System.out.println("---------------------------");
    }
    public static void arrayMidlle(){
        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
        int summAll = 0;
        int sumTmp = 0;
        for (int i = 0; i < arr.length; i++) {
            summAll += arr[i];
        }
        System.out.println(summAll);

        for (int i = 0; i < arr.length; i++){
            sumTmp += arr[i];
            if (sumTmp == summAll/2){
                System.out.println("Сумма элементов массива с 1 по " + (i+1) + " равна сумме элементов массива с " + (i+2) + " по " + arr.length);
                break;
            } else if (sumTmp == summAll){
                System.out.println("Центра массива нет.");
            }
        }
        System.out.println("---------------------------");
    }

}
