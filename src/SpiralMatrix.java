public class SpiralMatrix {
    static void spiralTraverse(int[][] arr){
        int rowSt = 0;
        int rowEnd = arr.length;
        int colSt = 0;
        int colEnd = arr[0].length;

        while(rowSt < rowEnd && colSt < colEnd){
            // Traverse Top Row
            for(int i = colSt; i < colEnd; i++){
                System.out.print(arr[rowSt][i] + " ");
            }
            rowSt++;

            // Traverse Right Column
            for(int i = rowSt; i < rowEnd; i++){
                System.out.print(arr[i][colEnd - 1] + " ");
            }
            colEnd--;

            // Traverse Bottom Row (if still in bounds)
            if(rowSt < rowEnd){
                for(int i = colEnd - 1; i >= colSt; i--){
                    System.out.print(arr[rowEnd - 1][i] + " ");
                }
                rowEnd--;
            }

            // Traverse Left Column (if still in bounds)
            if(colSt < colEnd){
                for(int i = rowEnd - 1; i >= rowSt; i--){
                    System.out.print(arr[i][colSt] + " ");
                }
                colSt++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
                {0,0,0}
        };
        spiralTraverse(arr); // ✅ No println needed
    }
}
