package classes;

public class finallyc {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        while(true) {
            try {
                int c = a / b;
                System.out.println(c);
            } catch (Exception e) {
                System.out.println(" i am at catch block");
                System.out.println(e);
                break;
            } finally {
                System.out.println("i am insode finally block for b value " + b);
                b--;
            }
        }
    }
}
