class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value)
            throws InterruptedException {
        while (available) {
            wait();
        }

        data = value;
        available = true;
        System.out.println("Producer produced: " + data);
        notifyAll();
    }

    public synchronized int consume()
            throws InterruptedException {
        while (!available) {
            wait();
        }

        int value = data;
        available = false;
        System.out.println("Consumer consumed: " + value);
        notifyAll();
        return value;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}

