import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Assignment_04 {
    static class Shop {
        int start;
        int end;
        Shop(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] s = {2, 5, 7, 6};
        int[] e = {3, 5, 8, 10};
        int k = 2;
        System.out.println(maxShops(s, e, k)); // Expected output: 4
    }

    static int maxShops(int[] s, int[] e, int k) {
        if (k <= 0 || s.length == 0) {
            return 0;
        }

        int n = s.length;
        Shop[] shops = new Shop[n];

        for (int i = 0; i < n; i++) {
            shops[i] = new Shop(s[i], e[i]);
        }

        // Sort shops by end time (primary) and start time (secondary)
        Arrays.sort(shops, Comparator.comparingInt((Shop a) -> a.end)
                .thenComparingInt(a -> a.start));

        // Using TreeSet to keep track of available persons' end times
        TreeSet<Integer> availableEndTimes = new TreeSet<>();

        // Initialize all persons as available at time 0
        for (int i = 0; i < k; i++) {
            availableEndTimes.add(0);
        }

        int count = 0;

        for (Shop shop : shops) {
            // Find the latest end time that is <= current shop's start time
            Integer availableTime = availableEndTimes.floor(shop.start);

            if (availableTime != null) {
                // Assign this shop to that person
                availableEndTimes.remove(availableTime);
                availableEndTimes.add(shop.end);
                count++;
            }
        }

        return count;
    }
}