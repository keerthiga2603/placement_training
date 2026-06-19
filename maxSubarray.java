public class maxSubarray {
    public static int maxSubArray(int[] nums) {
        int curr = 0;
        int maxsum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            maxsum = Math.max(maxsum, curr);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums)); // 6
    }
}