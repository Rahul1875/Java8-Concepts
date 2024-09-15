package src.com.pack.java8;

@FunctionalInterface
interface B{
    void display();
}

public class StaticMethodRef {

    public static void call() {
        System.out.println("inside call2()");
    }

    public static void main(String[] args){

        B b = StaticMethodRef::call;
        b.display();
    }

}
