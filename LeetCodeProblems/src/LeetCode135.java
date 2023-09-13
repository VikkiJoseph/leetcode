/**
 * https://leetcode.com/problems/candy/submissions/?envType=daily-question&envId=2023-09-13
 * @author JosephMiriyala
 */
public class LeetCode135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,2,2,1}));
        System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{1,2,2}));
    }
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];

        // Initialize every child with one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        // Calculate and return the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
}
