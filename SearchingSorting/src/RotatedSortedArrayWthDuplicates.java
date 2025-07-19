public class RotatedSortedArrayWthDuplicates {
    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    public boolean search(int[] nums, int target) {
        int pivot = pivot(nums);

        if(pivot == -1)
            return binarySearch(nums, target, 0, nums.length-1) != -1;
        if(nums[pivot] == target)
            return  pivot != -1;
        if(target >=  nums[0])
            return binarySearch(nums, target, 0, pivot-1) != -1;

        return binarySearch(nums, target, pivot + 1, nums.length-1) != -1;

    }
    int binarySearch(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid =  start + (end-start) / 2;
            if(target < nums[mid])
                end = mid-1;
            else if(target > nums[mid])
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }
    int pivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(mid<end && nums[mid] > nums[mid+1])
                return mid;
            if(start<mid && nums[mid] < nums[mid-1])
                return mid-1;
            if(nums[mid] == nums[start]  && nums[mid] == nums[end]){
                if(start<end && nums[start] > nums[start+1])
                    return start;
                start++;
                if(start<end && nums[end] < nums[end-1])
                    return end-1;
                end--;
                //till now left side is sorted

            }else if(nums[start]<nums[mid] || (nums[start]==nums[mid] && nums[end]< nums[mid]))
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
