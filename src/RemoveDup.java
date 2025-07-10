import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDup {
        public static int removeDuplicates(int[] arr) {
            int i = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] != arr[i]) {
                    arr[++i] = arr[j];
                }
            }
            return i + 1;
        }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,4,5,5,5,6};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
