public class BinarySearchRecursion {

    public static void main(String[] args) {
        int target =10;
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr,target,0,arr.length-1));
    }

    static int binarySearch(int[] arr,int target,int l,int h){
        if(l>h) return -1;
        int mid = l + (h-l) / 2;
        if(arr[mid] == target) return mid;
        if (arr[mid] > target)
            return binarySearch(arr,target,l,mid-1);
        else
            return binarySearch(arr,target,mid+1,h);

    }

}
