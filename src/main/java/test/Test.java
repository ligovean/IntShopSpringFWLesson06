package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
}


// 1 Что произойдет во время компиляции и выполнения данного кода?
class MyThread extends Thread {
    public void run() {
        System.out.print("Running ");
    }
    public void start() {
        System.out.print("Starting ");
    }
}

class Q202 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}














// 2 Каким будет результат компиляции и запуска данного кода:
class Super {
    Super() {
        System.out.println("Super contructor");
    }
}

class Main1 extends Super {
    Main1() {
        this(1);
        System.out.println("Main() contructor");
    }
    Main1(int i) {
        System.out.println("Main(int) contructor");
    }
    public static void main(String [] args) {
        new Main1();
    }
}
















// 3 Что напечатает следующий код:
//class Funcs extends java.lang.Math {
//
//    public int add(int x, int y) {
//        return x + y;
//    }
//    public int sub(int x, int y) {
//        return x - y;
//    }
//    public static void main(String[] a) {
//        Funcs f = new Funcs();
//        System.out.println("" + f.add(1, 2));
//    }
//}
//








// 4 Результат выполнения программы :
//class A {
//    public static void main(String[] args) {
//        Boolean f1 = true;
//        Boolean f2 = new Boolean("/false");
//        String a = "" + 1 + '+' + 1 + '=' + (1 + 1) + " is ";
//        String b = a + f1 + '/' + f2;
//        System.out.println(b);
//    }
//}
//
//






// Что произойдет при попытке запустить/откомпилировать следующий программный код?

class A {
    public static void main(String[] args){
        B b1 = new B("one","two");
        B b2 = new B("one", "two");
        B b3 = b1;
        System.out.println(b1 == b2);
        System.out.println(b1 == b3);
        System.out.println(b2 == b3);
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b3));
        System.out.println(b3.equals(b2));
    }
}

class B {
    public B(String prop1, String prop2){
        this.prop1 = prop1;
        this.prop2 = prop2;
    }
    private String prop1 = null;
    private String prop2 = null;
}






//////////


class Aaaa {
    private Double x = 2.0;
    public static void multX(Aaaa a, Double n) {
        a.setX(a.getX()*n);
    }
    public Double getX() {
        return x;
    }
    public void setX(Double xn) {
        x = xn;
    }
    public static void trippleValue(Double x) {
        x*=3;
    }
    public static Aaaa resetX(Aaaa a) {
        a = new Aaaa();
        return a;
    }

    public static void main(String[] args) {
        Double x = 4.0;
        trippleValue(x);
        Aaaa anA = new Aaaa();
        multX(anA,x);
        resetX(anA);
        System.out.print(anA.getX());
    }
}

/////////


class Test3 {
    public static void main(String[] args) {
        try {
            int i = 5;
        } catch (Exception e) {
            System.out.print("catch");
        } finally {
            System.out.print("finally");
        }
    }
}


















//  Что будет выведено на печать после выполнения данного кода?

class MapTest {
    public static void main( String[] args ) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();

        map1.put( "Number1", new Integer( 100 ) );
        map1.put( "Number2", new Integer( 200 ) );
        map1.put( "Number3", new Integer( 300 ) );

        List<Map> list = new ArrayList<Map>();
        list.add( map1 );
        list.add( map2 );

        HashMap resultMap = (HashMap) list.get( 0 );
        System.out.println( "Number: " + resultMap.get( "Number2" ) );
    }
}
