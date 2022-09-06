package test;

interface Com {
    int M = 200;

    int f();
}

class ImpCom implements Com {
    public int f() {
        return 100 + M;
    }

    public static void main(String[] args) {

    }


}