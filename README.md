# XỬ LÝ ĐỊNH DẠNG DỮ LIỆU

### 1. Java Regex (Biểu thức chính quy)
Regex hay Regular Expression là một API để xác định một mẫu tìm kiếm và thao tác với string.

__java.util.regex package__ gồm các thành phần sau:
- MatchResult interface
- Matcher class
- Pattern class
- PatternSyntaxException class

##### 1.1 Matcher class
`Matcher class implements MatchResult`. Matcher được sử dụng để thực hiện các hành động so sánh và đối chiều với chuỗi ký tự.

| # | Method                  | Mô tả                                                                |
|---|-------------------------|----------------------------------------------------------------------|
| 1 | boolean matches()       | Kiểm tra xem biểu thức chính quy có khớp với pattern hay không       |
| 2 | boolean find()          | Tìm biểu thức tiếp theo khớp với pattern                             |
| 3 | boolean find(int start) | Tìm biểu thức tiếp theo khớp với pattern từ số bắt đầu vị trí đã cho |
| 4 | String group()          | Trả về chuỗi con trùng khớp với pattern                              |
| 5 | int start()             | Trả về vị trí chuỗi con đầu tiên trùng khớp với pattern              |
| 6 | int end()               | Trả về vị trí chuỗi con cuối cùng trùng khớp với pattern             |
| 7 | int groupCount()        | Trả về số lượng chuỗi con trùng khớp với pattern                     |

##### 1.2 Pattern class
**Pattern class** là phiên bản biên dịch của biểu thức chính quy. Nó được dùng để xác định mẫu cho công cụ regex.

| # | Method                                                   | Mô tả                                                                  |
|---|----------------------------------------------------------|------------------------------------------------------------------------|
| 1 | static Pattern compile(String regex)                     | Biên dịch regex và trả về một instance của Pattern                     |
| 2 | Matcher matcher(CharSequence input)                      | Tạo `matcher` đối chiếu string đầu vào với pattern                     |
| 3 | static boolean matches(String regex, CharSequence input) | Biên dịch biểu thức chính quy và đối chiếu dữ liệu đầu vào với pattern |
| 4 | String[] split(CharSequence input)                       | Chia chuỗi đầu vào thành các chuỗi khớp với mẫu đã cho.                |
| 5 | String pattern()                                         | Trả về regex pattern                                                   |

##### 1.3 Các phương pháp viết Regex
Có 3 phương pháp tạo regex

- Phương pháp thứ nhất
```java
Pattern pattern = Pattern.compile("Jav."); // . đai diện cho 1 ký tự
Matcher matcher = pattern.matcher("Java");
boolean result1 = matcher.matches();
System.out.println(result1);

-- Kết quả --
true
```

- Phương pháp thứ hai
```java
boolean result2 = Pattern.compile("Jav.").matcher("Java").matches();
System.out.println(result2);

-- Kết quả --
true
```

- Phương pháp thứ ba
```java
boolean result2 = Pattern.compile("Jav.").matcher("Java").matches();
System.out.println(result2);

-- Kết quả --
true
```

- Ví dụ: ứng dụng trong Backend
```java
public class Main {
    public static void main(String[] args) {

        String[] searchConditions = {"username:Tay", "gender:male", "city:Hanoi", "sort:asc"};

        for (String condition : searchConditions) {
            Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)"); // (\w+?)(:|<|>)(.*)
            Matcher matcher = pattern.matcher(condition);
            if (matcher.find()) {
                System.out.println("condition = " + condition);

                if (matcher.group(1).equalsIgnoreCase("sort")) {
                    System.out.println("sort by " + matcher.group(3).toUpperCase());
                }
            }
        }
    }
}

-- Kết quả --
condition = username:Tay
condition = gender:male
condition = city:Hanoi
condition = sort:asc
sort by ASC
```

##### 1.4 Các loại Pattern
- __Regex Character classes__

| # | Character Class | Mô tả                                                 |
|---|-----------------|-------------------------------------------------------|
| 1 | [abc]           | a, b hoặc c (lớp đơn giản)                            |
| 2 | [^abc]          | Bất kỳ ký tự nào ngoại trừ a, b hoặc c (phủ định)     |
| 3 | [a-zA-Z]        | Từ a đến z hoặc từ A đến Z, bao gồm (phạm vi)         |
| 4 | [a-d[m-p]]      | a đến d, hoặc m đến p: [a-dm-p] (hợp nhất)            |
| 5 | [a-z&&[def]]    | d, e hoặc f (giao điểm)                               |
| 6 | [a-z&&[^bc]]    | Từ a đến z, ngoại trừ b và c: [ad-z] (trừ)            |
| 7 | [a-z&&[^m-p]]   | Từ a đến z, chứ không phải từ m đến p: [a-lq-z] (trừ) |

Ví dụ
```java
String regex1 = "[amn]";
System.out.println(Pattern.matches(regex1, "abcd")); // false (not a or m or n)
System.out.println(Pattern.matches(regex1, "a")); // true (among a or m or n)
System.out.println(Pattern.matches(regex1, "ammmna")); // false (m and a comes more than once)

-- Kết quả --
false
true
false
```

- __Regex Quantifiers__

| # | Regex  | Mô tả                                      |
|---|--------|--------------------------------------------|
| 1 | T?     | T xảy ra một lần hoặc không xảy ra lần nào |
| 2 | T+     | T xảy ra một hoặc nhiều lần                |
| 3 | T*     | T xảy ra 0 hoặc nhiều lần                  |
| 4 | T{n}   | T chỉ xảy ra n lần                         |
| 5 | T{n,}  | T xảy ra n lần hoặc nhiều hơn              |
| 6 | T{y,z} | T xảy ra ít nhất y lần nhưng ít hơn z lần  |

Ví dụ
```java
String regex2 = "[amn]?";
System.out.println("Regex = " + regex2);
System.out.println(Pattern.matches(regex2, "a"));//true (a or m or n comes one time)
System.out.println(Pattern.matches(regex2, "aaa"));//false (a comes more than one time)
System.out.println(Pattern.matches(regex2, "aammmnn"));//false (a m and n comes more than one time)
System.out.println(Pattern.matches(regex2, "aazzta"));//false (a comes more than one time)
System.out.println(Pattern.matches(regex2, "am"));//false (a or m or n must come one time)

String regex3 = "[amn]+";
System.out.println("Regex = " + regex3);
System.out.println(Pattern.matches(regex3, "a"));//true (a or m or n once or more times)
System.out.println(Pattern.matches(regex3, "aaa"));//true (a comes more than one time)
System.out.println(Pattern.matches(regex3, "aammmnn"));//true (a or m or n comes more than once)
System.out.println(Pattern.matches(regex3, "aazzta"));//false (z and t are not matching pattern)

String regex4 = "[amn]*";
System.out.println("Regex = " + regex4);
System.out.println(Pattern.matches(regex4, "ammmna"));//true (a or m or n may come zero or more times)
```

- __Regex Metacharacters__

| # | Regex | Mô tả                                                        |
|---|-------|--------------------------------------------------------------|
| 1 | .     | Bất kỳ ký tự nào (có thể hoặc không thể khớp với terminator) |
| 2 | \d    | Bất kỳ chữ số nào, ngắn hơn [0-9]                            |
| 3 | \D    | Bất kỳ số nào không phải chữ số, viết tắt của [^0-9]         |
| 4 | \s    | Bất kỳ ký tự khoảng trắng nào, viết tắt của [\t\n\x0B\f\r]   |
| 5 | \S    | Bất kỳ ký tự nào không phải khoảng trắng, viết tắt của [^\s] |
| 6 | \w    | Bất kỳ ký tự từ nào, viết tắt của [a-zA-Z_0-9]               |
| 7 | \W    | Bất kỳ ký tự nào không phải là từ, viết tắt của [^\w]        |
| 8 | \b    | Một từ giới hạn                                              |
| 9 | \B    | Một từ không giới hạn                                        |

```java
System.out.println("metacharacters = \\d"); // \\d means digit

System.out.println(Pattern.matches("\\d", "abc"));// false (non-digit)
System.out.println(Pattern.matches("\\d", "1")); // true (digit and comes once)
System.out.println(Pattern.matches("\\d", "4443")); // false (digit but comes more than once)
System.out.println(Pattern.matches("\\d", "323abc")); // false (digit and char)

System.out.println("metacharacters = \\D"); // \\D means non-digit

System.out.println(Pattern.matches("\\D", "abc")); // false (non-digit but comes more than once)
System.out.println(Pattern.matches("\\D", "1")); // false (digit)
System.out.println(Pattern.matches("\\D", "4443")); // false (digit)
System.out.println(Pattern.matches("\\D", "323abc")); // false (digit and char)
System.out.println(Pattern.matches("\\D", "m")); //true (non-digit and comes once)

System.out.println("metacharacters = \\D*");
System.out.println(Pattern.matches("\\D*", "mak")); // true (non-digit and may come 0 or more times)

-- Kết quả --
metacharacters = \d
false
true
false
false
metacharacters = \D
false
false
false
false
true
metacharacters = \D*
true
```

### 2. Xử lý chuyển đổi kiểu dữ liệu (Java Conversion)

- Java Convert `String` &rarr; `int`
```java
int a = Integer.parseInt("12");
System.out.println(a);

int b = Integer.valueOf("23");
System.out.println(b);

-- Kết quả --
12
23
```


### 3. Xử lý định dạng ngày tháng (Java Date)

##### 3.1 DateFormat

- __java.text.DateFormat Fields__
```java
protected Calendar calendar  
protected NumberFormat numberFormat  
public static final int ERA_FIELD  
public static final int YEAR_FIELD  
public static final int MONTH_FIELD  
public static final int DATE_FIELD  
public static final int HOUR_OF_DAY1_FIELD  
public static final int HOUR_OF_DAY0_FIELD  
public static final int MINUTE_FIELD  
public static final int SECOND_FIELD  
public static final int MILLISECOND_FIELD  
public static final int DAY_OF_WEEK_FIELD  
public static final int DAY_OF_YEAR_FIELD  
public static final int DAY_OF_WEEK_IN_MONTH_FIELD  
public static final int WEEK_OF_YEAR_FIELD  
public static final int WEEK_OF_MONTH_FIELD  
public static final int AM_PM_FIELD  
public static final int HOUR1_FIELD  
public static final int HOUR0_FIELD  
public static final int TIMEZONE_FIELD  
public static final int FULL  
public static final int LONG  
public static final int MEDIUM  
public static final int SHORT  
public static final int DEFAULT  
```

- __java.text.DateFormat Methods__

| #  | Methods                                                                                  | Mô tả                                                                                                       |
|----|------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| 1  | final String format(Date date)                                                           | Chuyển đổi đối tượng Date đã cho thành `String`                                                             |
| 2  | Date parse(String source)throws ParseException                                           | Chuyển đổi chuỗi thành đối tượng Date                                                                       |
| 3  | static final DateFormat getTimeInstance()                                                | Trả về định dạng thời gian với kiểu định dạng mặc định cho ngôn ngữ mặc định.                               |
| 4  | static final DateFormat getTimeInstance(int style)                                       | Trả về định dạng thời gian với kiểu định dạng được chỉ định cho ngôn ngữ mặc định.                          |
| 5  | static final DateFormat getTimeInstance(int style, Locale locale)                        | Trả về định dạng thời gian với kiểu định dạng được chỉ định cho ngôn ngữ được chỉ định                      |
| 6  | static final DateFormat getDateInstance()                                                | Trả về định dạng ngày tháng với kiểu định dạng mặc định cho ngôn ngữ mặc định.                              |
| 7  | static final DateFormat getDateInstance(int style)                                       | Trả về định dạng ngày tháng với kiểu định dạng được chỉ định cho ngôn ngữ mặc định                          |
| 8  | static final DateFormat getDateInstance(int style, Locale locale)                        | Trả về định dạng ngày tháng với kiểu định dạng được chỉ định cho ngôn ngữ được chỉ định.                    |
| 9  | static final DateFormat getDateTimeInstance()                                            | Trả về định dạng ngày/giờ với kiểu định dạng mặc định cho ngôn ngữ mặc định                                 |
| 10 | static final DateFormat getDateTimeInstance(int dateStyle,int timeStyle)                 | Trả về định dạng ngày/giờ với kiểu định dạng ngày và kiểu định dạng giờ được chỉ định cho ngôn ngữ mặc định |
| 11 | static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale) | Trả về định dạng ngày/giờ với kiểu định dạng ngày và kiểu định dạng giờ cho ngôn ngữ đã cho                 |
| 12 | static final DateFormat getInstance()                                                    | Trả về định dạng ngày/giờ với kiểu định dạng ngắn cho ngày và giờ                                           |
| 13 | static Locale[] getAvailableLocales()                                                    | Trả về một mảng các ngôn ngữ có sẵn                                                                         |
| 14 | Calendar getCalendar()                                                                   | Trả về một thể hiện của Calendar cho thể hiện DateFormat này                                                |
| 15 | NumberFormat getNumberFormat()                                                           | Trả về một thể hiện của NumberFormat cho thể hiện DateFormat này                                            |
| 16 | TimeZone getTimeZone()                                                                   | Trả về một thể hiện của TimeZone cho thể hiện DateFormat này                                                |

Ví dụ
```java
// Java Date Format
Date currentDate = new Date();
System.out.println("Current Date: " + currentDate);

String dateToStr = DateFormat.getInstance().format(currentDate);
System.out.println("DateFormat.getInstance(): " + dateToStr);

dateToStr = DateFormat.getDateInstance().format(currentDate);
System.out.println("DateFormat.getDateInstance(): " + dateToStr);

dateToStr = DateFormat.getTimeInstance().format(currentDate);
System.out.println("DateFormat.getTimeInstance(): " + dateToStr);

dateToStr = DateFormat.getDateTimeInstance().format(currentDate);
System.out.println("DateFormat.getDateTimeInstance(): " + dateToStr);

dateToStr = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate);
System.out.println("DateFormat.getTimeInstance(DateFormat.SHORT): " + dateToStr);

dateToStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(currentDate);
System.out.println("DateFormat.getTimeInstance(DateFormat.MEDIUM): " + dateToStr);

dateToStr = DateFormat.getTimeInstance(DateFormat.LONG).format(currentDate);
System.out.println("DateFormat.getTimeInstance(DateFormat.LONG): " + dateToStr);

dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
System.out.println("DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT): " + dateToStr);

-- Kết quả --
Current Date: Sun Sep 22 17:49:43 ICT 2024
DateFormat.getInstance(): 9/22/24, 5:49 PM
DateFormat.getDateInstance(): Sep 22, 2024
DateFormat.getTimeInstance(): 5:49:43 PM
DateFormat.getDateTimeInstance(): Sep 22, 2024, 5:49:43 PM
DateFormat.getTimeInstance(DateFormat.SHORT): 5:49 PM
DateFormat.getTimeInstance(DateFormat.MEDIUM): 5:49:43 PM
DateFormat.getTimeInstance(DateFormat.LONG): 5:49:43 PM ICT
DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT): September 22, 2024, 5:49 PM
```

##### 3.2 Java SimpleDateFormat

```java
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

-- Kết quả --
MM/dd/yyyy = 09/22/2024
dd-M-yyyy hh:mm:ss = 22-9-2024 06:14:06
dd MMMM yyyy = 22 September 2024
dd MMMM yyyy zzzz = 22 September 2024 Indochina Time
E, dd MMM yyyy HH:mm:ss z = Sun, 22 Sep 2024 18:14:06 ICT
```

##### 3.3 Convert `LocalDate` sang `String`
```java
// Date format pattern for convert
String DD_MM_YY = "ddMMyy";
String YYYY_MM_DD = "yyyy-MM-dd";
String DD_MM_YYYY = "dd/MM/yyyy";

// Convert LocalDate to String
// DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(DD_MM_YY);
// DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(YYYY_MM_DD);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
LocalDate localDate = LocalDate.now();
String dateFormatted = localDate.format(formatter);
System.out.println(dateFormatted);

-- Kết quả --
22/09/2024
```

### 4. Bài tập
Xử lý convert tứ String theo các đinhh dạng khác nhau