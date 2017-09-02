package recAndDp;

public class WaysOfChange {
    public static int getWaysOfChange(int[] bills, int aim) {
        return compressed(bills, aim);
    }

    public static int compressed(int[] bills, int aim) {
        int[] ways = new int[aim + 1];
        ways[0] = 1;
        for (int i = 1; i <= aim; i++) {
            if (i % bills[0] == 0)
                ways[i] = 1;
            else ways[i] = 0;
        }
        for (int i = 1; i < bills.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j >= bills[i])
                    ways[j] += ways[j - bills[i]];
            }
        }
        return ways[aim];
    }
}
