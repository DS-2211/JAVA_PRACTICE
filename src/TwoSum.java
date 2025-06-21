import java.util.Arrays;

public class TwoSum {

    static int[] twoSum(int[] arr, int target){
        int[] res=new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                    res[0]=arr[i];
                    res[1]=arr[j];
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,7,2,9};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }

}
