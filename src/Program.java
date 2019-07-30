import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        MyTreeMap<Character, Integer> treeMap = new MyTreeMap<>();
        treeMap.put('S', 1);
        treeMap.put('E', 2);
        treeMap.put('A', 3);
        treeMap.put('R', 4);
        treeMap.put('C', 5);
        treeMap.put('H', 6);
        treeMap.put('X', 8);
        treeMap.put('M', 9);

        System.out.println(treeMap.get('A').toString());
        System.out.println(treeMap.size());
        ArrayList<MyTreeMap> treeMapArray = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            treeMapArray.add(new MyTreeMap());
            for (int t = 0; t < 200; t++) {
                if (treeMapArray.get(i).heightOfTree() == 6){
                    break;
                } else {
                    treeMapArray.get(i).put((int) ((Math.random() * 200) - 100), (int) ((Math.random() * 200) - 100));
                }
            }
        }

        System.out.println("Sizes: ");
        for (int i = 0; i < treeMapArray.size(); i++) {
            System.out.print(treeMapArray.get(i).size() + " ");
        }
        System.out.println("\nHeights: ");
        int balanced = 0;
        for (int i = 0; i < treeMapArray.size(); i++) {
            System.out.print(treeMapArray.get(i).heightOfTree() + " ");
            System.out.print(treeMapArray.get(i).isBalanced() + " \n");
            if (treeMapArray.get(i).isBalanced() == true){
                balanced += 1;
            }
        }
        System.out.println("Balanced in 100: " + balanced);

    }
}
