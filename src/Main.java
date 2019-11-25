public class Main {

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        System.out.println(solution.isMatch("aba", "ab*a*c*a"));
    }
}
