/**
 * Артур Резник, Java. Уровень 1 урок 1, 27.05.2019
 */
public class Lesson_01 {
    public static void main(String[] args) {
        byte by = 1;
        short sh = 10;
        int num = 100;
        long lo = 100500L;
        char a = '\u2242';
        float fl = 0.1f;
        double dob = 0.001;
        boolean tr = true;
    }

    static int calc (int a, int b, int c, int d){
        int result = a*(b+(c/d));
        return result;
    }
    static boolean layBetween(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }
    static void numCheck (int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное(или ноль)");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }
    static boolean negativeCheck (int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }
    static void helloYourName (String name) {
        System.out.println("Привет, " + name + "!");
    }
    static void leapYearCheck (int year) {
        if (year % 400 == 0) {
            System.out.println(year + " год високосный.");
        } else if (year % 100 != 0) {
            System.out.println(year + " год не високосный.");
        } else if (year % 4 == 0) {
            System.out.println(year + " год високосный.");
        } else {
            System.out.println(year + " год не високосный.");
        }
    }
}
