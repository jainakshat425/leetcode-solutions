public class Queue {

    private static final int N = 5000;
    private int[] data;
    private int head;
    private int tail;

    Queue() {
        data = new int[N];
        head = -1;
        tail = -1;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return head == -1;
    }

    void enqueue(int data) {
        if (isFull()) {
            return;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % N;
        this.data[tail] = data;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int value = this.data[head];
        if (size() == 1) {
            head = -1;
            tail = -1;
        } else {
            head++;
        }
        return value;
    }

    int front() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[head];
    }

    boolean isFull() {
        return size() == N;
    }

    int size() {
        return (tail < head) ? (N - head + tail + 1) : (tail - head + 1);
    }
}
