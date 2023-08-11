import java.util.ArrayList;

public class DynamicList<T> {
    int size;
    int capacity;
    Object[] elements;

    public DynamicList(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }
    public DynamicList() {
        this.capacity = 20;
        elements = new Object[capacity];
    }

    public boolean add(T element){
        if (size >= capacity) {
            capacity += 10;
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
        elements[size] = element;
        size++;
        return true;
    }

}
