public class SearchRotatedArray {
    public int search(int[] arr, int target) {
        int low=0,high=arr.length-1;
        int pivot = findPivot(arr);
        if(target > arr[high]){
            return findTarget(arr,target,0,pivot-1);
        }
        else{
            return findTarget(arr,target,pivot,high);
        }
    }
    public int findTarget(int[] arr,int target,int low,int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public int findPivot(int[] arr){
        int low=0,high=arr.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(arr[mid] > arr[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

    }
}
