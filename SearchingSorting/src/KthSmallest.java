public class KthSmallest {
    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
    public int kthSmallestElementInASortedArray(int[][] matrix, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i< matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                if(heap.size() < k)
                    heap.add(matrix[i][j]);
                else{
                    if(heap.peek() > matrix[i][j]){
                        heap.poll();
                        heap.add(matrix[i][j]);
                    }

                }

            }
        }
        return heap.peek();
    }
}
