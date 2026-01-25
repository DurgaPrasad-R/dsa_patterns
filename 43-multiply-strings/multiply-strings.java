class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] indices = new int[m+n];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p2 = i + j + 1;
                int p1 = i + j;
                
                int sum = mul + indices[p2];
                indices[p2] = sum % 10;
                indices[p1] += sum / 10;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i : indices) {
            if (!(result.length() == 0 && i == 0)) {
                result.append(i);
            }
        }

        return result.toString();
    }
}