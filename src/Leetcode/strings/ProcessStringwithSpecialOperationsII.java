package Leetcode.strings;

public class ProcessStringwithSpecialOperationsII {

        public char processStr(String s, long k) {

            int n = s.length();
            long[] len = new long[n];

            long curr = 0;

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                if (Character.isLowerCase(ch)) {
                    curr++;
                } else if (ch == '*') {
                    if (curr > 0) curr--;
                } else if (ch == '#') {
                    curr = Math.min(curr * 2, 1000000000000000L);
                }
                len[i] = curr;
            }

            if (k >= curr)
                return '.';

            for (int i = n - 1; i >= 0; i--) {

                char ch = s.charAt(i);
                long after = len[i];
                long before = (i == 0) ? 0 : len[i - 1];

                if (Character.isLowerCase(ch)) {

                    if (k == after - 1)
                        return ch;

                } else if (ch == '*') {



                } else if (ch == '#') {

                    if (before > 0 && k >= before)
                        k -= before;

                } else { // %

                    k = before - 1 - k;

                }
            }

            return '.';
        }
    }

