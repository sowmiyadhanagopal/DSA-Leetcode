package Leetcode.dp;

public class NumberofZigZagArraysII {

        private static final long MOD = 1_000_000_007L;

        public int zigZagArrays(int n, int l, int r) {
            int m = r - l + 1;
            int size = 2 * m;

            long[] base = new long[size];

            for (int v = 0; v < m; v++) {
                base[v] = v;
                base[m + v] = m - 1 - v;
            }

            long[][] trans = new long[size][size];

            for (int v = 0; v < m; v++) {
                for (int u = 0; u < v; u++) {
                    trans[v][m + u] = 1;
                }
            }

            for (int v = 0; v < m; v++) {
                for (int u = v + 1; u < m; u++) {
                    trans[m + v][u] = 1;
                }
            }

            long[][] power = matrixPower(trans, n - 2);
            long[] result = multiply(power, base);

            long ans = 0;
            for (long x : result) {
                ans = (ans + x) % MOD;
            }

            return (int) ans;
        }

        private long[] multiply(long[][] mat, long[] vec) {
            int n = mat.length;
            long[] res = new long[n];

            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = 0; j < n; j++) {
                    sum = (sum + mat[i][j] * vec[j]) % MOD;
                }
                res[i] = sum;
            }

            return res;
        }

        private long[][] matrixPower(long[][] mat, long exp) {
            int n = mat.length;
            long[][] result = new long[n][n];

            for (int i = 0; i < n; i++) {
                result[i][i] = 1;
            }

            long[][] base = mat;

            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = multiply(result, base);
                }
                base = multiply(base, base);
                exp >>= 1;
            }

            return result;
        }

        private long[][] multiply(long[][] a, long[][] b) {
            int n = a.length;
            long[][] res = new long[n][n];

            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (a[i][k] == 0) continue;

                    long val = a[i][k];

                    for (int j = 0; j < n; j++) {
                        if (b[k][j] == 0) continue;
                        res[i][j] = (res[i][j] + val * b[k][j]) % MOD;
                    }
                }
            }

            return res;
        }
    }
