public class peakIndexInMountainArray {
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    //https://leetcode.com/problems/find-peak-element/
    public int peakIndexInMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid  = start + (end - start) / 2;
            if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;

    }
}
