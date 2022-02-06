public class BasicQueue {
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.println(q.poll());
        System.out.println("front=" + q.front());
        System.out.println("rear=" + q.rear());
    }

    static class Queue {
        int rear, front, count, size, arr[];

        Queue(int size) {
            this.arr = new int[size];
            this.size = size;
            rear = -1;
            front = 0;
            count = 0;
        }

        boolean isFull() {
            return this.count == this.size;
        }

        boolean isEmpty() {
            return this.count == 0;
        }

        void add(int x) {
            if (isFull()) {
                System.out.println("queue full");
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = x;
            count++;
            System.out.println(x + " added to queue");
            // System.out.println("front= " + front);
            // System.out.println("rear= " + rear);
        }

        int poll() {
            if (isEmpty()) {
                System.out.println("No elements left in the queue");
                return Integer.MIN_VALUE;
            }

            int item = arr[front];

            front = (front + 1) % size;
            size--;
            System.out.println(item + " deleted from queue");
            // System.out.println("front= " + front);
            // System.out.println("rear= " + rear);
            return item;
        }

        int front() {

            if (isEmpty()) {
                System.out.println("No elements left in the queue");
                return Integer.MIN_VALUE;
            }
            return arr[front];
        }

        int rear() {
            if (isEmpty()) {
                System.out.println("No elements left in the queue");
                return Integer.MIN_VALUE;
            }
            return arr[rear];
        }

    }
}
