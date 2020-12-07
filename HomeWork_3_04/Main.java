package HomeWork_3_04;

public class Main {
//    private final Object monitor = new Object();
    private static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main w1 = new Main();

        new Thread(() -> {
            w1.printA();
        }).start();
        new Thread(() -> {
            w1.printB();
        }).start();
        new Thread(() -> {
            w1.printC();
        }).start();
    }

    public synchronized void printA() {
     //   synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        wait();
                    }
                    notifyAll();
                    System.out.print("A");
                    currentLetter = 'B';
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
     //   }
    }

    public synchronized void printB() {
     //   synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        wait();
                    }
                    notifyAll();
                    System.out.print("B");
                    currentLetter = 'C';
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
      //  }
    }

    public synchronized void printC() {
     //   synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        wait();
                    }
                    notifyAll();
                    System.out.print("C");
                    currentLetter = 'A';
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
     //   }
    }
}

