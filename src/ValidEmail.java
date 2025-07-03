public class ValidEmail {


        // Public façade ----------------------------------------------------------
        public static boolean isValid(String email) {
            if (email == null) return false;

            int len = email.length();

            // 1. Basic length and single '@' checks ------------------------------
            if (len < 3) return false;                 // a@b   -> shortest possible
            int at = email.indexOf('@');
            if (at <= 0 || at != email.lastIndexOf('@') || at == len - 1) return false;

            // 2. Split local part and domain part --------------------------------
            String local  = email.substring(0, at);
            String domain = email.substring(at + 1);

            // 3. Validate local part ---------------------------------------------
            if (!checkLocal(local))   return false;

            // 4. Validate domain part --------------------------------------------
            return checkDomain(domain);
        }

        // -----------------------------------------------------------------------
        // Helpers
        // -----------------------------------------------------------------------

        private static boolean checkLocal(String s) {
            int n = s.length();
            // Leading or trailing dot is disallowed; consecutive dots too.
            if (s.charAt(0) == '.' || s.charAt(n - 1) == '.') return false;

            char prev = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '.') {
                    if (prev == '.') return false;           // two dots in a row
                } else if (!isAllowedLocalChar(c)) {
                    return false;
                }
                prev = c;
            }
            return true;
        }

        private static boolean isAllowedLocalChar(char c) {
            // RFC 5322 is generous; here we keep the “safe” ASCII subset.
            return isLetterOrDigit(c) ||
                    c == '_' || c == '-' || c == '.' || c == '+';
        }

        private static boolean checkDomain(String s) {
            int n = s.length();
            // Must contain at least one dot separating labels.
            int dotPos = s.indexOf('.');
            if (dotPos <= 0 || dotPos == n - 1) return false;

            // No leading, trailing, or consecutive dots.
            if (s.charAt(0) == '.' || s.charAt(n - 1) == '.') return false;

            char prev = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '.') {
                    if (prev == '.') return false;           // double dot
                } else if (!isAllowedDomainChar(c)) {
                    return false;
                }
                prev = c;
            }

            // Simple TLD length sanity check (2-63).
            String tld = s.substring(s.lastIndexOf('.') + 1);
            return tld.length() >= 2 && tld.length() <= 63;
        }

        private static boolean isAllowedDomainChar(char c) {
            return isLetterOrDigit(c) || c == '-' || c == '.';
        }

        private static boolean isLetterOrDigit(char c) {
            return (c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9');
        }
        // -----------------------------------------------------------------------
        // Demo harness -----------------------------------------------------------
        // -----------------------------------------------------------------------
        public static void main(String[] args) {

            String[] samples = {
                    "alice@example.com",
                    "bob.smith@dev.foo.org",
                    "bad.@example.com",
                    "no..dots@example.com",
                    "missingatsign.com",
                    "a@b",
                    "toolongtld@example.abcdefghijklm",
                    "good+tag@sub-domain.example.co"
            };
            for (String s : samples) {
                System.out.printf("%-32s : %s%n", s, isValid(s));
            }
        }
    }


