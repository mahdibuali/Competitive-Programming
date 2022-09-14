public class Dobra {
    public static boolean is_vowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String x = "JA_BU_K_A";
        boolean can_be_vowel = true;
        boolean can_be_con = true;
        int n = x.length();
        long result = 1;
        for (int i = 0; i < n; i++) {
            boolean c1; boolean c2; boolean c3; boolean c4;
            if (i > 1 && i < n - 2) {
                c1 = is_vowel(x.charAt(i - 2));
                c2 = is_vowel(x.charAt(i - 1));
                c3 = is_vowel(x.charAt(i + 1));
                c4 = is_vowel(x.charAt(i + 2));
                if ((c1 && c2) || (c3 && c4) || (c2 && c3)) {
                    can_be_vowel = false;
                }
                if ((!c1 && !c2) || (!c3 && !c4) || (!c2 && !c3)) {
                    can_be_con = false;
                }
            }
            if (i == 0) {
                c3 = is_vowel(x.charAt(i + 1));
                c4 = is_vowel(x.charAt(i + 2));
                if (c3 && c4) {
                    can_be_vowel = false;
                }
                if (!c3 && !c4) {
                    can_be_con = false;
                }
            }
            if (i == 1) {
                c2 = is_vowel(x.charAt(i - 1));
                c3 = is_vowel(x.charAt(i + 1));
                c4 = is_vowel(x.charAt(i + 2));
                if ((c3 && c4) || (c2 && c3)) {
                    can_be_vowel = false;
                }
                if ((!c3 && !c4) || (!c2 && !c3)) {
                    can_be_con = false;
                }
            }
            if (i == n - 2) {
                c1 = is_vowel(x.charAt(i - 2));
                c2 = is_vowel(x.charAt(i - 1));
                c3 = is_vowel(x.charAt(i + 1));
                if ((c1 && c2) || (c2 && c3)) {
                    can_be_vowel = false;
                }
                if ((!c1 && !c2) || (!c2 && !c3)) {
                    can_be_con = false;
                }
            }
            if (i == n - 1) {
                c1 = is_vowel(x.charAt(i - 2));
                c2 = is_vowel(x.charAt(i - 1));

                if (c1 && c2) {
                    can_be_vowel = false;
                }
                if (!c1 && !c2) {
                    can_be_con = false;
                }
            }
            
        }
    }
}
