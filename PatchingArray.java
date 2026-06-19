public class PatchingArray {

    public static int minPatches(int[] nums, int n) {
        long till = 1;   // smallest missing number
        int patches = 0;
        int i = 0;

        while (till <= n) {
            if (i < nums.length && nums[i] <= till) {
                till += nums[i];
                i++;
            } else {
                till += till;   // patch with till
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int n = 6;

        System.out.println(minPatches(nums, n)); // Output: 1
    }
}