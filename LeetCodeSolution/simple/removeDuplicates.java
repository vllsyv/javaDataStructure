package LeetCodeSolution.simple;

public class removeDuplicates {
    public static void main(String[] args){
        int[] nums = {1,1,2};
        int count = new removeDuplicates().new Solution().removeDuplicates(nums);
        System.out.println(count);
        for (int i = 0;i<=count;i++ ){
            System.out.println(nums[i]);
        }
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int count = 0;
            int pre = 0;
            if(nums.length == 0) {
                return 0;
            }
            if(nums.length == 1) {
                return 1;
            }
            pre = nums[0];
            for(int i = 1;i<nums.length;i++) {
                if(nums[i]!= pre){
                    count++;
                    nums[count] = nums[i] ;
                }
                pre = nums[i];
            }
            return count;
        }
    }
}
