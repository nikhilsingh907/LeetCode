
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = -1;

        for (char ch : s.toCharArray()) {
            rows[row].append(ch);

            if (row == 0 || row == numRows - 1) {
                direction = -direction;
            }

            row += direction;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder r : rows) {
            result.append(r);
        }

        return result.toString();
    }
}
