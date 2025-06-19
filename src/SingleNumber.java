public class SingleNumber {
        public static void main(String[] args) {
            int[] arr = {1,4,7,6,6,4,1};
            System.out.println( findUnique(arr) );

        }

        static int findUnique(int[] arr){
            int res =0;
            for(int i=0;i<arr.length;i++){
                res^=arr[i];
            }
            return res;
        }

}
