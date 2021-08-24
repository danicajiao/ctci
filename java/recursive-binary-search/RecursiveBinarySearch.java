/**
 * ---------RECURSIVE BINARY SEARCH---------
 * 
 * A search algorithm that finds the position of a target value within a sorted
 * array. Binary search compares the target value to the middle element of the
 * array.
 * 
 * NOTE: For Java, this approach is intuitive. However it has worse space
 * complexity than iterative binary search because each recursive call creates
 * an array half the size.
 * 
 * Data Structure: Array
 * 
 * Prerequisite: In order for a binary search to work, the target array HAS TO
 * BE SORTED
 * 
 * Average complexity: O(log n)
 * 
 * Worst complexity: O(log n)
 * 
 * Best complexity: O(1)
 * 
 * Space complexity: O(log n)
 * 
 * -----------------------------------------
 */
public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 8, 9, 11, 13, 15, 19, 21 };
        // int[] nums = { 1, 2 };
        int low = 0;
        int high = nums.length - 1;

        recBinarySearch(nums, low, high, 8); // Average case: sorted array - O(log n)
        recBinarySearch(nums, low, high, 21); // Worst case: target is first or last element - O(log n)
        recBinarySearch(nums, low, high, 11); // Best case: target is first midpoint - O(1)
        recBinarySearch(nums, low, high, 10); // Another case: target is not found - O(log n)
    }

    public static void recBinarySearch(int[] nums, int low, int high, int x) {
        if (high < low) {
            System.out.println(x + " Not found");
            return;
        }

        // Since overflow may occur with (low + high) / 2, it is best to use:
        int mid = low + ((high - low) / 2);

        // If midpoint equals target, return
        if (nums[mid] == x) {
            System.out.println("Found " + x + " at index " + mid);
            return;
        }
        // If midpoint is greater than target, search left subarray
        else if (nums[mid] > x) {
            recBinarySearch(nums, low, mid - 1, x);
            return;
        }
        // If midpoint is less than target, search right subarray
        else if (nums[mid] < x) {
            recBinarySearch(nums, mid + 1, high, x);
            return;
        }
    }
}
