import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;

public class AaDS_lesson_2 {

    public static void main(String[] args) {
        int ARRAY_LENGTH = 50000;
        MyArrayList<Integer> myNewList = new MyArrayList<>();
        MyArrayList<String> result = new MyArrayList<>();

        for (int i = 0; i < ARRAY_LENGTH; i++){
            myNewList.add((int)(Math.random()*10));
        }

        for (int rate = 0; rate < 100; rate++){
            long delta = 0;
            long sortt = 0;
            long inst = 0;
            MyArrayList<Integer> selectSortList = new MyArrayList<>();
            MyArrayList<Integer> insertationSortList = new MyArrayList<>();
            for (int j = 0; j < ARRAY_LENGTH; j++){
                selectSortList.add(myNewList.get(j));
            }

            for (int h = 0; h < ARRAY_LENGTH; h++){
                insertationSortList.add(myNewList.get(h));
            }
            long startTime = System.currentTimeMillis();
            selectSortList.selectionSort(Integer::compareTo);
            long sortTime = System.currentTimeMillis() - startTime;
            sortt = sortTime;
            System.out.println(rate + " selection try " + sortTime);
            result.add(rate + " selection try " + sortTime);

            startTime = System.currentTimeMillis();
            insertationSortList.insertionSort(Integer::compareTo);
            sortTime = System.currentTimeMillis() - startTime;
            inst = sortTime;
            System.out.println(rate + " insertation try " + sortTime);
            delta = sortt -inst;
            result.add(rate + " selection try " + sortTime );
            if (delta > 0){
                result.add("insertation method win with: " + Math.abs(delta) + "\n");
            } else if (delta < 0){
                result.add("select method win with: " + Math.abs(delta) + "\n");
            } else {
                result.add("withdraw \n");
            }
        }
        System.out.println(result.toString());
        try (FileWriter writer = new FileWriter("src/output" + ARRAY_LENGTH +".txt", false)){
            writer.write("" + result.toString());
        } catch (IOException e){
            System.out.println(e);
        }
    }

}
class MyArrayList <Item> {
    private int size = 0;
    private Object[] list = new Object[1];

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void set(int index, Item item) { //arr[index] = item;
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty() { return size == 0; }

    public boolean contains(Item item) { return indexOf(item) != -1; }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }
    public void add(Item item) {
        if (size == list.length) {
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;
        if (size == list.length / 4 && size > 0) {
            resize(list.length /2);
        }
        return true;
    }
    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i] + ", ");
        }
        return s.toString();
    }

    //@Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<Item> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) list[cursor];
            cursor++;
            return item;
        }
    }

    private void exch(int i, int j) {
        Object temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) {
        return cmp.compare(item1, item2) < 0;
    }

    public void selectionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[min], cmp)) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    public void insertionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0 ; j--) {
                if (less((Item) list[j], (Item) list[j - 1], cmp)) {
                    exch(j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }

    public boolean binarySearch(Item item, Comparator<Item> cmp) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;// (a + b) / 2
            if (cmp.compare(item, (Item) list[mid]) < 0) {
                high = mid - 1;
            }
            else if (cmp.compare(item, (Item) list[mid]) > 0) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

