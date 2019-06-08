/**
 * @author Артур Резник,
 * @version Java. Уровень 1 урок 3, 08.06.2019
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

	System.out.println("Выбор игры 1 - Угадай число, 2 - Угадай слово");
	int gameChoice = Integer.parseInt(in.readLine());
	if (gameChoice == 1){
        guessNumber();
    } else if (gameChoice == 2) {
        fieldOfWoundersReplay();
    }

    }
    public static void guessNumber() throws IOException{
        while (true){
            int number = number();
            //System.out.println(number);
            guess(number);
            System.out.println("Еще разок? (1 - да, 0 - нет)");
            int again = Integer.parseInt(in.readLine());
            if (again == 0){
                break;
            }
        }
    }
    public static int number(){
        int number = (int)(Math.random() * 10);
        return number;
    }
    public static void guess(int number) throws IOException {

        System.out.println("Загаданное число от 0 до 9");
        for (int i = 0; i < 3; i++){
            int test = Integer.parseInt(in.readLine());
            //System.out.println(test);
            if (test == number){
                System.out.println("Вы победили, загаданное число " + number);
                break;
            } else if (test > number){
                System.out.println("Загаданное число меньше введенного");
            } else if (test < number){
                System.out.println("Загаданное число больше введенного");
            }

        }

    }
    public static void fieldOfWoundersReplay() throws IOException{
        while (true) {
            gameProcedure();
        }
    }
    public static void gameProcedure() throws IOException{
        String secretWord = secretWord();
        int secretWordLength = secretWord.length();
        System.out.println(secretWord);
        String fieldOfWonders = fieldOfWonders();
        System.out.println(fieldOfWonders);
        int counter = 0;

        while (true) {
            if (counter == secretWordLength) {
                System.out.println("Вы не отгадали слово до открытия всех букв компьютером.");
                break;
            }
            String reply = askWord();
            if (reply.equals(secretWord)) {
                System.out.println("Вы угадали слово " + secretWord);
                break;
            } else {
                if (secretWord.length() < reply.length()){
                    for (int i = 0; i < secretWord.length(); i++){
                        if (reply.charAt(i) == secretWord.charAt(i));
                            char[] newField = fieldOfWonders.toCharArray();
                            newField[i] = reply.charAt(i);
                            fieldOfWonders = new String(newField);
                    }
                } else {
                    for (int i = 0; i < reply.length(); i++){
                        if (reply.charAt(i) == secretWord.charAt(i)){
                            char[] newField = fieldOfWonders.toCharArray();
                            newField[i] = reply.charAt(i);
                            fieldOfWonders = new String(newField);

                        }
                    }
                }
                System.out.println(fieldOfWonders);
                counter++;
            }
        }
    }
    public static String askWord() throws IOException{
        System.out.println("Ведите слово на английском");
        String word = in.readLine();
        return word;
    }
    public static String fieldOfWonders(){
        String secretWordHided = "###############";
        //System.out.println(secretWordHided);
        return secretWordHided;
    }
    public static String secretWord(){
        System.out.println();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int rand = (int)(Math.random()*25 + 1);
        return words[rand];
    }

}
