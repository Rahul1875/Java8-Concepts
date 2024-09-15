package src.com.pack.java8;

@FunctionalInterface
interface C{
    Hello dispaly(String say);
}

class Hello{
    public Hello(String say){
        System.out.println(say);
    }

    public Hello() {
        System.out.println("rahul");
    }
}

public class ConsMethodRef {

     public static void main(String[] args){

         C c = Hello::new;
         c.dispaly("hello world");
     }
}
