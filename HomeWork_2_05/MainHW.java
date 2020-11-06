package HomeWork_2_05;

public class MainHW {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    public static void methodOne() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[1] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("MethodOne " + (System.currentTimeMillis() - a));
    }

    public static void methodTwo() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        for (int i = 0; i < h; i++) {
            arr[1] = 1;
        }

        long a = System.currentTimeMillis();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, 0, arr1, 0, h);
                for (int i = 0; i < h; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(arr1, 0, arr, 0, h);
                System.out.println("MethodTwo Thread1 " + (System.currentTimeMillis() - a));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, h, arr2, h, h);
                for (int i = 0; i < h; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(arr2, 0, arr, 0, h);
                System.out.println("MethodTwo Thread2 " + (System.currentTimeMillis() - a));
            }
        }).start();
    }
}