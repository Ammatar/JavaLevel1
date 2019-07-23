public class AaDS_lesson_5 {
    public static void main(String[] args) {
        degree(2, 8);
        System.out.println(degreeRec(2,8));
    }

    public static int degreeRec(int base, int degree){
        if (base == 1){
            return 1;
        } else if (degree == 1) {
            return base;
        } else {
            return degreeRec(base, degree - 1) * base;
        }

    }

    public static void degree(int base, int degree) {
        int sum = base;
        degree--;
        while (degree > 0){
            sum = sum * base;
            degree--;
        }
        System.out.println(sum);
    }
}
