import java.util.ArrayList;

public class SimpleStack {
    private ArrayList<Integer> elements;

    public SimpleStack() {
        elements = new ArrayList<>();
    }

    public void push(int value) {
        elements.add(value);
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() { return elements.isEmpty(); }
    public int size() { return elements.size(); }
}