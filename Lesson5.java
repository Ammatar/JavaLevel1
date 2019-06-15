/**
 * @author Артур Резник,
 * @version Java. Уровень 1 урок 4, 11.06.2019
 */
/* * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;*/
public class Lesson5 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Anatoly", "Manager", "an@an.com", 890000110, 120000, 30);
        persArray[1] = new Person("Anatoly", "Manager", "an@an.com", 890000110, 120000, 45);
        persArray[2] = new Person("Anatoly", "Manager", "an@an.com", 890000110, 120000, 50);
        persArray[3] = new Person("Anatoly", "Manager", "an@an.com", 890000110, 120000, 40);
        persArray[4] = new Person("Anatoly", "Manager", "an@an.com", 890000110, 120000, 30);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                System.out.println(persArray[i]);
            }
        }
    }
}
    class Person{
        String name;
        String position;
        String email;
        long phone;
        int salary;
        int age;
        Person(String name, String position, String email, long phone, int salary, int age){
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }
        @Override
        public String toString(){
            return "Name: " + name + " Position: " + position + " Email: " + email + "\nPhone: " + phone + " Salary: " + salary + " Age: " + age;
        }

    }

