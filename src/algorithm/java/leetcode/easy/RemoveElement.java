package algorithm.java.leetcode.easy;

public class RemoveElement {
    /*
    27. Remove Element
     */

    public int removeElement(int[] nums, int val) {
        int k = 0;
        int end = nums.length-1;
        if(nums.length == 1 && nums[0] == val) return k;
        for (int i = 0; i < nums.length - k; i++){
            int num = nums[i];
            if (num == val) {
                while(i != end && nums[end] == val){
                    end--;
                    k++;
                }
                nums[i] = nums[end];
                nums[end] = num;
                end--;
                k++;
            }
        }
        return nums.length - k;
    }

    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
