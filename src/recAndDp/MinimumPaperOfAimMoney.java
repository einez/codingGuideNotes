package recAndDp;

import java.util.Arrays;

public class MinimumPaperOfAimMoney {
    public static int getMinimumPaperOfAimMoney(int[] bills, int aim) {
        int[] banknotes = Arrays.copyOf(bills, bills.length);
//        Arrays.sort(banknotes);
        int[][] dp = new int[aim + 1][banknotes.length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            if (i % banknotes[0] != 0)
                dp[i][0] = Integer.MAX_VALUE;
            else dp[i][0] = i / banknotes[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i >= banknotes[j] && dp[i - banknotes[j]][j] < dp[i][j - 1] - 1)
                    dp[i][j] = dp[i - banknotes[j]][j] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1][dp[0].length - 1];
    }

    public static int compressed(int[] bills, int aim) {
        int[] helper = new int[aim + 1];
        helper[0] = 0;
        for (int i = 1; i < helper.length; i++) {
            if (i % bills[0] != 0)
                helper[i] = Integer.MAX_VALUE;
            else helper[i] = i / bills[0];
        }
        for (int i = 1; i < bills.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j >= bills[i] && helper[j - bills[i]] < helper[j] - 1)
                    helper[j] = helper[j - bills[i]] + 1;
            }
        }
        return helper[aim] == Integer.MAX_VALUE ? -1 : helper[aim];
    }
}
