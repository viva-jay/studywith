import java.util.Arrays;

public class highestValuePalindrome {
    public static void main(String[] args) {
        String s = "932239";
        int n = s.length();
        int k = 2;
        String result = highestValuePalindrome(s,n,k);
        System.out.println(result);
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = s.charAt(i-1) - '0';
        }

        int atLeastCnt = 0;
        for(int i=1; i<=n/2; i++) {
            if (arr[i] != arr[n-i+1]) atLeastCnt++;
        }

        if(atLeastCnt > k) return "-1";
        else {
            if (k == 0) return s;
            if (k == 1) {
                if (n % 2 == 0 && atLeastCnt == 0) return "-1";
            }

            int extraCnt = k - atLeastCnt;
            for(int i=1; i<=n/2; i++) {
                if (arr[i] != arr[n-i+1]) {
                    int max = Math.max(arr[i], arr[n-i+1]);
                    if (max != 9 && atLeastCnt >= 1 && extraCnt >= 1) {
                        arr[i] = 9;
                        arr[n-i+1] = 9;
                        atLeastCnt = atLeastCnt - 1;
                        extraCnt = extraCnt - 1;
                    }
                    else if (atLeastCnt >= 1) {
                        arr[i] = max;
                        arr[n-i+1] = max;
                        atLeastCnt = atLeastCnt - 1;
                    }
                }
                else {
                    if (arr[i] != 9 && extraCnt >= 2) {
                        arr[i] = 9;
                        arr[n-i+1] = 9;
                        extraCnt = extraCnt - 2;
                    }
                }
            }

            if (extraCnt > 0) {
                if (n % 2 == 1) arr[n/2 + 1] = 9;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) sb.append(arr[i]);
        return sb.toString();
    }
}
