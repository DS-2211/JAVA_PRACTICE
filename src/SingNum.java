public class SingNum {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,1,2,2,4,4,4,4};
        System.out.println(sinNumb(arr));
    }

    static int sinNumb(int[] arr){
        int res=0;
        for(int i=0;i<32;i++){
            int sum=0;
            int x = (1 << i);

            for(int num : arr){
                if((num & x) != 0){
                    sum++;
                }
            }

            if(sum%4 !=0){
                res |= x;
            }
        }
        return res;
    }
}
