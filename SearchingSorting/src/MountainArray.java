public class MountainArray {
    //https://leetcode.com/problems/find-in-mountain-array/description/
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int firstTry = orderAgnosticBS(mountainArr,  target, 0, peak);
        if(firstTry != -1)
            return firstTry;
        return orderAgnosticBS(mountainArr,  target, peak+1, mountainArr.length() - 1);

    }
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while(start < end){
            int mid  = start + (end - start) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;

    }

    public int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end){

        boolean flag = mountainArr.get(start) < mountainArr.get(end);
        while(start <= end){
            int mid = start + (end -start) / 2;
            if(mountainArr.get(mid) == target)
                return mid;
            if(flag){
                if(target < mountainArr.get(mid))
                    end = mid -1;
                else
                    start = mid + 1;
            }else{
                if(target > mountainArr.get(mid))
                    end = mid -1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
