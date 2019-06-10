/**
 * @author Артур Резник,
 * @version Java. Уровень 1 урок 4, 11.06.2019
 */
import java.util.*;

class TicTacToe {

    final int SIZE = 5; // must be odd number
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map;
    Scanner sc;
    Random rand;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        map = new char[SIZE][SIZE];
        sc = new Scanner(System.in);
        rand = new Random();
    }

    void game() {
        initMap();
        while (true) {
            printMap();
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("SORRY DRAW!");
                break;
            }
            aiTurn();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("SORRY DRAW!");
                break;
            }
        }
        printMap();
   }

    void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X space Y coord [1.." + SIZE + "]:");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[x][y] = DOT_O;
    }

    boolean checkWin(char dot) {
        // check horizontals
        int counter = 0;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map[j][i] == dot){
                    counter++;
                }
            }
            if (counter == SIZE){
                return true;
            }
            counter = 0;
        }
        /*if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true; */
        // check verticals

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == dot){
                    counter++;
                }
            }
            if (counter == SIZE){
                return true;
            }
            counter = 0;
        }
        /*if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;*/
        // check diagonals
        for (int i = 0; i < SIZE; i++){
            if (map[i][i] == dot){
                counter++;
            }
            if (counter == SIZE){
                return true;
            }

        }
        counter = 0;
        for (int i = 0; i < SIZE; i++){
            if (map[SIZE - i - 1][i] == dot){
                counter++;
            }
            if (counter == SIZE){
                return true;
            }

        }
        //counter = 0;
        /*if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;*/
        return false;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[x][y] == DOT_EMPTY;
    }
}