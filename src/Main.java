package src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        String[] searchConditions = {"username:Tay", "gender:male", "city:Hanoi", "sort:asc"};
//
//        for (String condition : searchConditions) {
//            Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)"); // (\w+?)(:|<|>)(.*)
//            Matcher matcher = pattern.matcher(condition);
//            if (matcher.find()) {
//                System.out.println("condition = " + condition);
//
//                if (matcher.group(1).equalsIgnoreCase("sort")) {
//                    System.out.println("sort by " + matcher.group(3).toUpperCase());
//                }
//            }
//        }

        // Phương pháp thứ nhất
//        Pattern pattern = Pattern.compile("Jav."); // . đai diện cho 1 ký tự
//        Matcher matcher = pattern.matcher("Java");
//        boolean result1 = matcher.matches();
//        System.out.println(result1);
//
//        // Phương pháp thứ hai
//        boolean result2 = Pattern.compile("Jav.").matcher("Java").matches();
//        System.out.println(result2);
//
//        // Phương pháp thứ ba
//        boolean result3 = Pattern.matches("Jav.", "Java");
//        System.out.println(result3);

        // Regex Character classes
//        String regex1 = "[amn]";
//        System.out.println("Regex = " + regex1);
//        System.out.println(Pattern.matches(regex1, "abcd")); // false (not a or m or n)
//        System.out.println(Pattern.matches(regex1, "a")); // true (among a or m or n)
//        System.out.println(Pattern.matches(regex1, "ammmna")); // false (m and a comes more than once)

        // Regex Quantifiers
//        String regex2 = "[amn]?";
//        System.out.println("Regex = " + regex2);
//        System.out.println(Pattern.matches(regex2, "a")); // true (a or m or n comes one time)
//        System.out.println(Pattern.matches(regex2, "aaa")); // false (a comes more than one time)
//        System.out.println(Pattern.matches(regex2, "aammmnn")); // false (a m and n comes more than one time)
//        System.out.println(Pattern.matches(regex2, "aazzta")); // false (a comes more than one time)
//        System.out.println(Pattern.matches(regex2, "am")); //false (a or m or n must come one time)
//
//        String regex3 = "[amn]+";
//        System.out.println("Regex = " + regex3);
//        System.out.println(Pattern.matches(regex3, "a")); // true (a or m or n once or more times)
//        System.out.println(Pattern.matches(regex3, "aaa")); // true (a comes more than one time)
//        System.out.println(Pattern.matches(regex3, "aammmnn")); // true (a or m or n comes more than once)
//        System.out.println(Pattern.matches(regex3, "aazzta")); // false (z and t are not matching pattern)
//
//        String regex4 = "[amn]*";
//        System.out.println("Regex = " + regex4);
//        System.out.println(Pattern.matches(regex4, "ammmna"));//true (a or m or n may come zero or more times)

//        System.out.println("metacharacters = \\d"); // \\d means digit
//
//        System.out.println(Pattern.matches("\\d", "abc"));// false (non-digit)
//        System.out.println(Pattern.matches("\\d", "1")); // true (digit and comes once)
//        System.out.println(Pattern.matches("\\d", "4443")); // false (digit but comes more than once)
//        System.out.println(Pattern.matches("\\d", "323abc")); // false (digit and char)
//
//        System.out.println("metacharacters = \\D"); // \\D means non-digit
//
//        System.out.println(Pattern.matches("\\D", "abc")); // false (non-digit but comes more than once)
//        System.out.println(Pattern.matches("\\D", "1")); // false (digit)
//        System.out.println(Pattern.matches("\\D", "4443")); // false (digit)
//        System.out.println(Pattern.matches("\\D", "323abc")); // false (digit and char)
//        System.out.println(Pattern.matches("\\D", "m")); //true (non-digit and comes once)
//
//        System.out.println("metacharacters = \\D*");
//        System.out.println(Pattern.matches("\\D*", "mak")); // true (non-digit and may come 0 or more times)


        // Java Conversion
        int a = Integer.parseInt("12");
        System.out.println(a);

        int b = Integer.valueOf("23");
        System.out.println(b);







//        // Date format pattern for convert
//        String DD_MM_YY = "ddMMyy";
//        String YYYY_MM_DD = "yyyy-MM-dd";
//        String DD_MM_YYYY = "dd/MM/yyyy";
//
//        // Convert LocalDate to String
//        // DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(DD_MM_YY);
//        // DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(YYYY_MM_DD);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
//        LocalDate localDate = LocalDate.now();
//        String dateFormatted = localDate.format(formatter);
//        System.out.println(dateFormatted);
//
//
//        // Java Date Format
//        Date currentDate = new Date();
//        System.out.println("Current Date: " + currentDate);
//
//        String dateToStr = DateFormat.getInstance().format(currentDate);
//        System.out.println("DateFormat.getInstance(): " + dateToStr);
//
//        dateToStr = DateFormat.getDateInstance().format(currentDate);
//        System.out.println("DateFormat.getDateInstance(): " + dateToStr);
//
//        dateToStr = DateFormat.getTimeInstance().format(currentDate);
//        System.out.println("DateFormat.getTimeInstance(): " + dateToStr);
//
//        dateToStr = DateFormat.getDateTimeInstance().format(currentDate);
//        System.out.println("DateFormat.getDateTimeInstance(): " + dateToStr);
//
//        dateToStr = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate);
//        System.out.println("DateFormat.getTimeInstance(DateFormat.SHORT): " + dateToStr);
//
//        dateToStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(currentDate);
//        System.out.println("DateFormat.getTimeInstance(DateFormat.MEDIUM): " + dateToStr);
//
//        dateToStr = DateFormat.getTimeInstance(DateFormat.LONG).format(currentDate);
//        System.out.println("DateFormat.getTimeInstance(DateFormat.LONG): " + dateToStr);
//
//        dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
//        System.out.println("DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT): " + dateToStr);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println("MM/dd/yyyy = " + strDate);

        formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        strDate = formatter.format(date);
        System.out.println("dd-M-yyyy hh:mm:ss = " + strDate);

        formatter = new SimpleDateFormat("dd MMMM yyyy");
        strDate = formatter.format(date);
        System.out.println("dd MMMM yyyy = " + strDate);

        formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");
        strDate = formatter.format(date);
        System.out.println("dd MMMM yyyy zzzz = " + strDate);

        formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        strDate = formatter.format(date);
        System.out.println("E, dd MMM yyyy HH:mm:ss z = " + strDate);

    }
}
