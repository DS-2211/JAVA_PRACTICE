public class FirstAndLastPos {
    //    public int[] searchRange(int[] nums, int target) {
//        if()
//    }
//
//    public int search(int[] arr,int target,int low,int high,int cnt){
//        while(low<=high){
//            int mid = low + (high-low)/2;
//            if(arr[mid] == target){
//                return search(arr,target,low,mid-1,0);
//            }
//            if(arr[mid] < target){
//                low = mid+1;
//            }
//            else{
//                high=mid-1;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//
//    }
    public int[] searchRange(int[] arr, int target) {

        int[] res = new int[2];
        res[0] = findEle(arr,target,0);
        res[0] = findEle(arr,target,1);
        return res;
    }

    public int findEle(int[] arr,int target,int cnt){
        int low = 0, high = arr.length - 1,ans =1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans=mid;
                if(cnt == 0){
                    high = mid;
                }
                else{
                    low = mid+1;
                }
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
