import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of fthe product is $2.5 2,5 2.,5";
        Pattern pattern = Pattern.compile("(-?)(\\d+)((\\.|,)\\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}