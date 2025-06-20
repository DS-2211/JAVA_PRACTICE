public class MagicNum {
    public static void main(String[] args) {
        System.out.println(magicNumber(3));
    }

    static int magicNumber(int pos){
        int res=0;
        for(int i=0;i<pos;i++){
            int x = (1<<i);

            if((pos & x) != 0){
                res+= (int) Math.pow(5,i);
            }
        }
        return res;
    }
}
