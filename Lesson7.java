/**
 * @author Артур Резник,
 * @version Java. Уровень 1 урок 7, 22.06.2019
 * @testIsPassed https://geekbrains.ru/certificates/606968
 */

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.util.*;

public class Lesson7 {

    public static void main(String[] args) {
        //Cats initialisation
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Vaska", 7, false));

        cats.add(new Cat("Borya", 5, false));

        //Plate initialisation
        Plate plate = new Plate(10);
        //JFrame object creation
        JFrame frame = new Init(cats);
        // Feed first cat
        cats.get(0).eat(plate, frame, cats.get(0));
        // Feed second cat
        plate.putSomeFood(5,frame);
        cats.get(1).eat(plate, frame, cats.get(1));
    }
}

    class Init extends JFrame {
        JTextArea text = new JTextArea();

        Init(ArrayList cats) {
            JFrame frame = new JFrame();
            frame.setTitle("Cats");
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);

            Button exitBtn = new Button("Exit");
            exitBtn.addActionListener(e -> System.exit(0));


            text.append(initText(cats));
            frame.add(text, BorderLayout.CENTER);

            frame.add(exitBtn, BorderLayout.SOUTH);
            frame.setVisible(true);
        }

        public String initText(ArrayList cats) {
            String text = "";
            for (int i = 0; i < cats.size(); i++) {
                text += cats.get(i).toString() + "\n";
            }
            return text;
        }

        public String appendText(String addText) {
            text.append(addText + "\n");
            return addText;
        }
    }

    class Cat {
        private String name;
        private int appetit;
        private boolean satisfied;

        Cat(String name, int appetit, boolean satisfied) {
            this.name = name;
            this.appetit = appetit;
            this.satisfied = satisfied;
        }

        public boolean getSatisfied() {
            return satisfied;
        }
        public void setIsSatisfied(){
            this.satisfied = true;
        }
        public int getAppetit(){
            return appetit;
        }
        public String getName(){
            return name;
        }

        void eat(Plate plate, JFrame frame, Cat cat) {
            ((Init)frame).appendText("Cat want to eat " + appetit + " food");
            plate.decreaceFoodLevel(appetit, frame, cat);
        }

        @Override
        public String toString() {
            return "Cat name: " + name + " Appetit: " + appetit + " Is " + name + " satisfied " + satisfied;
        }
    }

    class Plate {
        private int foodLevel;
        final int VOLUME = 10;

        Plate(int foodLevel) {
            this.foodLevel = foodLevel;
        }

        void decreaceFoodLevel(int food, JFrame frame, Cat cat) {

            if (this.foodLevel >= food) {
                this.foodLevel -= food;
                ((Init)frame).appendText("Food in plate: " + foodLevel);
                cat.setIsSatisfied();
                ((Init)frame).appendText(cat.getName() + " satisfaction is " + cat.getSatisfied());
            } else {
                ((Init)frame).appendText("Not enouth food in plate");
            }
        }

        public void putSomeFood(int i, JFrame frame){
            if (foodLevel + i <= VOLUME){
                foodLevel += i;
                ((Init)frame).appendText(i + " food puted in plate, and now " + foodLevel + " there");
            } else {
                ((Init)frame).appendText("Not enouth " + (foodLevel + i - VOLUME) + " place for food in plate");
            }
        }
        @Override
        public String toString(){
            return "Food in plate: " + foodLevel;
        }
    }
