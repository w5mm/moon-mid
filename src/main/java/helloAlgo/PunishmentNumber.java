package helloAlgo;

public class PunishmentNumber {




        static final int MAX = 1000;
        static final int[] F = new int[MAX + 1];

        static {F[1] = 1;}


        public int punishmentNumber(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (check(i * i, i)) ans += i * i;
            }
            return ans;
        }
        boolean check(int t, int x) {
            if (t == x) return true;
            int d = 10;
            while (t >= d && t % d <= x) {
                if (check(t / d, x - (t % d))) return true;
                d *= 10;
            }
            return false;
        }


        public static void main(String[] args) {
            PunishmentNumber p = new PunishmentNumber();
            System.out.println(p.punishmentNumber(10));


        }
        public  static String  makeSmallestPalindrome(String str){
            char[] p = str.toCharArray();
            int n = p.length;
            for(int i = 0; i < n/2; i++){
                char x = p[i], y = p[n-i-1];
                if(x > y){
                    p[i] = y;

                }else {
                    p[n-1-i-1] = x;
                }

            }
            return new String(p);


        }
}
