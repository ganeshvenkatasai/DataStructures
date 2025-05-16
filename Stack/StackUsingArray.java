import java.util.EmptyStackException;

class Main {
    public static void main(String[] args) {
        Stack s = new Stack(3); // Test with small capacity
        s.push(10);
        s.push(20);
        s.push(30);
        
        System.out.println("Popped: " + s.pop());
        System.out.println("Top element: " + s.peek());
        s.display();
    }
}

class Stack {
    private int capacity;
    private int top;
    private int[] stackArray;

    public Stack() {
        this(100); // Default capacity
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1; // Initialize top to -1 (empty stack)
        this.stackArray = new int[capacity];
    }

    public void push(int value) {
        if (isFull()) {
            resize(); // Double the capacity if full
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newStack = new int[newCapacity];
        System.arraycopy(stackArray, 0, newStack, 0, capacity);
        stackArray = newStack;
        capacity = newCapacity;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}
