import java.util.Arrays;

class Solution {
    private int[][] mem;
    private int[] nextEvent;
    private int n;

    private int attendEvent(int[][] events, int pos, int k) {
        if (k == 0 || pos >= n) {
            return 0;
        }
        if (mem[pos][k] != -1) {
            return mem[pos][k];
        }

        int skipEvent = attendEvent(events, pos + 1, k);

        int next = nextEvent[pos];
        int attendEventVal = attendEvent(events, next, k - 1) + events[pos][2];
        return mem[pos][k] = Math.max(skipEvent, attendEventVal);
    }

    public int maxValue(int[][] events, int k) {
        n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        mem = new int[n][k + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        nextEvent = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (events[mid][0] > events[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            nextEvent[i] = left;
        }

        return attendEvent(events, 0, k);
    }
}