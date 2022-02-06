class MyBase {
    public void func() {
        System.out.println("Base static called");
    }
}

class test extends MyBase {
    public void func() { // is this allowed?
        System.out.println("Derived static called");
    }
}