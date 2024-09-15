package src.com.pack.java8;

@FunctionalInterface
interface A{
    void display();
}

public class InstanceMethodRef {

    public  void call() {
        System.out.println("inside call()");
    }

    public static void main(String[] args){

        InstanceMethodRef instanceMethodRef = new InstanceMethodRef();
        A a = instanceMethodRef::call;
        a.display();
    }



}
