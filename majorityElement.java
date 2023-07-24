public class majorityElement {
    private static int countInRange(int[] nums, int num, int lo, int hi){
        int count = 0;
        for(int i = lo; i <= hi; i++){
            if(nums[i] == num) count++;
        }
        return count;

    }

    private static int majorityElementrec(int[] nums, int lo, int hi){
        if(lo == hi){
            return nums[lo];
        }
        int mid = (lo + hi) / 2;
        int left  = majorityElementrec(nums, lo, mid);
        int right = majorityElementrec(nums, mid + 1, hi);

        if (left==right){
            return left;
        }

        int leftCount = countInRange(nums, left, lo,hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? leftCount : rightCount;
    }
    public static int majorityElement(int[] nums){
        return majorityElementrec(nums, 0, nums.length - 1);
    }
    public static void main(String[] args){
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    
}
