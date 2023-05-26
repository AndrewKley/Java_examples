public class Inheritance {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        // A abc = new C();

        // a.sayHi1();
        // b.sayHi1();
        // c.sayHi1();
        // a.sayHi2();
        // b.sayHi2();
        // c.sayHi2();
        a.sayHi3();
        b.sayHi3();
        c.sayHi3();
   }
}

class A {
    // private int age = 7;

    public void sayHi1() {
        System.out.println("A've said Hi1 ");
    }

    public void sayHi2() {
        System.out.println("A've said Hi2 ");
    }

    public void sayHi3() {
        System.out.println("A've said Hi3 ");
    }
}

class B extends A {
    // private int age = 3;
    // default int age = 3;
    protected int age = 3;

    public void sayHi1() {
        System.out.println("B've said Hi1 ");
    }
}

class C extends B {
    public void sayHi3() {
        System.out.println("C've said Hi3 " + age);
    }
}