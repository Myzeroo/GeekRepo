package HomeWork_3_04;

public class Main {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main w = new Main();

        new Thread(() -> {w.printA();}).start();
        new Thread(() -> {w.printB();}).start();
        new Thread(() -> {w.printC();}).start();
    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    monitor.notifyAll();
                    System.out.print("A");
                    currentLetter = 'B';
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    monitor.notifyAll();
                    System.out.print("B");
                    currentLetter = 'C';
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    monitor.notifyAll();
                    System.out.print("C");
                    currentLetter = 'A';
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

