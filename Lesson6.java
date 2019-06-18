
/**
 * @author Артур Резник,
 * @version Java. Уровень 1 урок 6, 18.06.2019
 */

public class Lesson6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vasya","red", 2);
        System.out.println(cat1);
        System.out.println(cat1.run(150));
        System.out.println(cat1.getMaxRunDistance());
        cat1.setMaxRunDistance(400);
        System.out.println(cat1.getMaxRunDistance());
        System.out.println(cat1.swim(6));
        System.out.println(cat1.jump(1.5));
        Dog dog1 = new Dog("Bobik","green", 3);
        System.out.println(dog1);
        System.out.println(dog1.run(1000));
    }
}
interface IMoving{
    String run(int runDistance);
    String swim(double swimDistance);
    String jump(double jumpDistance);
}
abstract class Animal implements IMoving{
    protected String name;
    protected String color;
    protected int age;

    public Animal(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;

    }
    @Override
    public String toString(){
        return name + " " + color + " " + age;
    }

}
class Cat extends Animal{
    int maxRunDistance = 200;
    double maxJumpDistance = 2;

    public Cat(String name, String color, int age){
        super(name, color, age);
    }

    public String run(int runDistance) {
        if (runDistance <= maxRunDistance && runDistance > 0){
            return "run: " + runDistance + "m true";
        } else {
            return "run:" + runDistance + "m false";
        }
    }
    public String swim(double swimDistance){
        return "swim: false";
    }
    public String jump(double jumpDistance){
        if (jumpDistance <= maxJumpDistance && jumpDistance > 0){
            return "jump: " + jumpDistance + "m true";
        } else {
            return "jump: " + jumpDistance + "m false";
        }
    }
    public int getMaxRunDistance(){
        return maxRunDistance;
    }
    public void setMaxRunDistance(int maxRunDistance){
        this.maxRunDistance = maxRunDistance;
    }
    public double getMaxJumpDistance(){
        return maxJumpDistance;
    }
    public void setMaxJumpDistance(double maxJumpDistance){
        this.maxJumpDistance = maxJumpDistance;
    }

}
class Dog extends Animal{
    int maxRunDistance = 500;
    double maxSwimDistance = 10;
    double maxJumpDistance = 0.5;

    public Dog(String name, String color, int age){
        super(name,color,age);
    }

    public String run(int runDistance) {
        if (runDistance <= maxRunDistance && runDistance > 0){
            return "run: " + runDistance + "m true";
        } else {
            return "run: " + runDistance + "m false";
        }
    }
    public String swim(double swimDistance) {
        if (swimDistance <= maxSwimDistance && swimDistance > 0){
            return "swim: " + swimDistance + "m true";
        } else {
            return "swim: " + swimDistance + "m false";
        }
    }
    public String jump(double jumpDistance){
        if (jumpDistance <= maxJumpDistance && jumpDistance > 0){
            return "jump: " + jumpDistance + "m true";
        } else {
            return "jump: " + jumpDistance + "m false";
        }
    }
    public int getMaxRunDistance(){
        return maxRunDistance;
    }
    public void setMaxRunDistance(int maxRunDistance){
        this.maxRunDistance = maxRunDistance;
    }
    public double getMaxSwimDistance(){
        return maxSwimDistance;
    }
    public void setMaxSwimDistance(double maxSwimDistance){
        this.maxSwimDistance = maxSwimDistance;
    }
    public double getMaxJumpDistance(){
        return maxJumpDistance;
    }
    public void setMaxJumpDistance(double maxJumpDistance){
        this.maxJumpDistance = maxJumpDistance;
    }
}