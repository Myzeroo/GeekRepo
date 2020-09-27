package HomeWork_01;

public class Main {
    public static void main(String[] args) {

        boolean bl1 = true;
        byte b1 = 127;
        short sh1 = 32767;
        char ch1 = 'Z';
        int i1 = 123456;
        long l1 = 123456L;
        float f1 = 123.456F;
        double d1 = 123.456;
        String str1 = "Оливье";

    }
    static int getResult(int a, int b, int c, int d){
        return  a * (b + (c / d));
    }
    static boolean checkSumm(int a, int b){
        if(  10 < (a+b) && (a+b) <= 20  )return true;
        return false;
    }
    static void printSign(int a){
        if( a >=0 ) System.out.println("Положительное число");
        else System.out.println("Отрицатльное число");
    }

    static boolean isNegative(int a){
        if(a<0)return true;
        return false;
    }

    static void printMsg(String a){
        System.out.println("Привет, " + a + "!");
    }

    static void printLeapYear(int year){
        if(year%400 == 0){
            System.out.println("Високосный год");
        }else if (year%100 == 0 ){
            System.out.println("Невисокосный год");
        }else if(year%4==0){
            System.out.println("Високосный год");
        }else{
            System.out.println("Невисокосный год");
        }
    }
}

