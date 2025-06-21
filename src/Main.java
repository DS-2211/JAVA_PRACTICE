class Main {

    public static void main(String[] args) {
        int[] arr = {222, 2, 1};
        System.out.println(pivot(arr));
    }

    static int pivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.length == 1) return arr[0];


            if (mid == 0) {
                if (arr[0] > arr[1]) return arr[0];
                else low = mid + 1;
            }


            else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) return arr[mid];
                else high = mid - 1;
            }


            else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid];
                } else if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
