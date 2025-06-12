class Main{
    static void fun(int n){
        if(n==0) return;
        System.out.println(n%2);
        fun(n/2);
    }
    public static void main(String[] args) {
        fun(25);
        }

}