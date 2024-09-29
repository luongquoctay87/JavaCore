# Internationalization and Localization in Java

- Internationalization = i18n (Quốc tế hoá)
- Localization = l10n (Bản địa hoá)

### 1. Internationalization = i18n (Quốc tế hoá)
Trước khi áp dụng I18N chúng ta cần hiểu một số dữ liệu cần phụ thuộc khu vực địa lý và văn hoá.
- Messages
- Dates
- Times
- Numbers
- Currencies
- Measurements
- Phone Numbers
- Postal Addresses
- Labels on GUI components etc

- classs Locale 

Lớp `Locale` đại diện cho một khu vực địa lý hoặc văn hoá, Locale này có thể được sử dụng để lấy thông tin cụ thể về địa phương như tên quốc gia, ngôn ngữ, biến thể, v.v.

- Các fields trong Locale
```java
public static final Locale ENGLISH;
public static final Locale FRENCH;
public static final Locale GERMAN;
public static final Locale ITALIAN;
public static final Locale JAPANESE;
public static final Locale KOREAN;
public static final Locale CHINESE;
public static final Locale SIMPLIFIED_CHINESE;
public static final Locale TRADITIONAL_CHINESE;
public static final Locale FRANCE;
public static final Locale GERMANY;
public static final Locale ITALY;
public static final Locale JAPAN;
public static final Locale KOREA;
public static final Locale CHINA;
public static final Locale PRC;
public static final Locale TAIWAN;
public static final Locale UK;
public static final Locale US;
public static final Locale CANADA;
public static final Locale CANADA_FRENCH;
public static final Locale ROOT;
```

- Các Constructors của lớp `Locale`
```java
Locale(String language);
Locale(String language, String country);
Locale(String language, String country, String variant);
```

- Các phương thức của lớp `Locale`

| # | Method                                | Mô tả                                                                   |
|---|---------------------------------------|-------------------------------------------------------------------------|
| 1 | static Locale getDefault()            | Trả về thể hiện của Locale hiện tại                                     |
| 2 | static Locale[] getAvailableLocales() | Trả về một mảng các ngôn ngữ có sẵn                                     |
| 3 | String getDisplayCountry()            | Trả về tên quốc gia theo local hiện tại                                 |
| 4 | String getDisplayLanguage()           | Trả về tên ngôn ngữ theo local hiện tại                                 |
| 5 | String getDisplayVariant()            | Trả về mã biến thể theo local hiện tại                                  |
| 6 | String getISO3Country()               | Trả về chữ viết tắt gồm ba chữ cái cho quốc gia hiện tại                |
| 7 | String getISO3Language()              | Trả về chữ viết tắt gồm ba chữ cái cho ngôn ngữ của địa phương hiện tại |

- Thông tin ngôn ngữ mặc định
```java
public class Main {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();

        System.out.println("getCountry(): "+ locale.getCountry());
        System.out.println("getDisplayCountry(): "+ locale.getDisplayCountry());

        System.out.println("getLanguage(): " + locale.getLanguage());
        System.out.println("getDisplayLanguage(): " + locale.getDisplayLanguage());

        System.out.println("getDisplayName(): "+ locale.getDisplayName());

        System.out.println("getISO3Country(): " + locale.getISO3Country());
        System.out.println("getISO3Language(): "+ locale.getISO3Language());

    }
}
```

- Chuyển từ tiếng việt sang ngôn ngữ khác
```java
public class Main {
    public static void main(String[] args) {
        Locale vnLocale = new Locale("vi", "VN");
        Locale chinaLocale = Locale.CHINA;
        Locale japanLocale = Locale.JAPAN;

        System.out.println("getDisplayLanguage(): " + vnLocale.getDisplayLanguage());
        System.out.println("getDisplayLanguage(vnLocale): " + vnLocale.getDisplayLanguage(vnLocale));

        System.out.println("CHINA: " + chinaLocale.getDisplayLanguage());  // print Chinese
        System.out.println("CHINA: " + chinaLocale.getDisplayLanguage(vnLocale)); // print Tiếng Trung
        System.out.println("JAPAN: " + japanLocale.getDisplayLanguage()); // Japanese
        System.out.println("JAPAN: " + japanLocale.getDisplayLanguage(vnLocale)); // Tiếng Nhật
    }
}
```

- Hiển thị ngôn ngữ từ nhiều local
```java
public class Main {
    public static void main(String[] args) {
        
        Locale[] locales = {new Locale("en", "GB"), new Locale("fr", "FR"), new Locale("es", "ES")};
        for (int i = 0; i < locales.length; i++) {
            String displayLanguage = locales[i].getDisplayLanguage(locales[i]);
            System.out.println(locales[i] + ": " + displayLanguage);
        }
    }
}

-- Kết quả --
en_GB: English
fr_FR: français
es_ES: español
```

### 2. ResourceBundle class in Java

Lớp `ResourceBundle` được sử dụng để quốc tế hóa các message. Nói cách khác, chúng ta có thể nói rằng nó cung cấp một cơ chế để toàn cầu hóa các message.

Các phương thức của `ResourceBundle`

| # | Method                                                          | Mô tả                                                                |
|---|-----------------------------------------------------------------|----------------------------------------------------------------------|
| 1 | static ResourceBundle getBundle(String basename)                | Trả về `instance` của lớp ResourceBundle theo ngôn ngữ mặc định      |
| 2 | static ResourceBundle getBundle(String basename, Locale locale) | Trả về `instance` của lớp ResourceBundle theo ngôn ngữ được chỉ định |
| 3 | String getString(String key)                                    | Trả về giá trị theo key chỉ định từ ResourceBundle                   |


### 3. Internationalizing Currency (Quốc tế hoá tiền tệ)
Hiển thị tiền tệ theo định dạng của từng khu vực địa lý hoặc quốc gia

```java
public static NumberFormat getCurrencyInstance(Locale locale);
```

- Ví dụ:
```java
public class Main {
    public static void main(String[] args) {
        NumberFormat vnFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        NumberFormat jpyFormatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        NumberFormat usdFormatter = NumberFormat.getCurrencyInstance(Locale.US);

        String vnd = vnFormatter.format(10500.3245);
        String jpy = jpyFormatter.format(10500.3245);
        String usd = usdFormatter.format(10500.3245);

        System.out.println("vnđ: " + vnd);
        System.out.println("jpy: " + jpy);
        System.out.println("usd: " + usd);
    }
}

-- kết quả --
vnđ: ₫10,500
jpy: ￥10,500
usd: $10,500.32
```

### 4. Internationalizing Date (Quốc tế hoá ngày tháng năm)
Hiển thị ngày tháng năm theo định dạng của từng khu vực địa lý hoặc quốc gia

| # | Method                                                      | Mô tả                                           |
|---|-------------------------------------------------------------|-------------------------------------------------|
| 1 | static DateFormat getDateInstance(int style, Locale locale) | Trả về DateFormat theo locale và style chỉ định |
| 2 | public String format(Date date)                             | Trả về một string định dạng và nội địa hoá      |

- Ví dụ:
```java
public class Main {
    public static void main(String[] args) {
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
        Date currentDate = new Date();
        String date = formatter.format(currentDate);
        System.out.println(date);
    }
}

-- Kết quả --
Sep 29, 2024
```

### 5. Internationalizing Time (Quốc tế hoá thời gian)
Hiển thị thời gian theo định dạng của từng khu vực địa lý hoặc quốc gia

```java
public static DateFormat getTimeInstance(int style, Locale locale); 
```

- Ví dụ:
```java
public class Main {
    public static void main(String[] args) {
        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.getDefault());
        Date currentDate = new Date();
        String time = formatter.format(currentDate);
        System.out.println(time);
    }
}

-- Kết quả --
4:41:41 PM
```
---
## Bài tập
Xây dựng các common method để convert date, time, number, currency theo locale chỉ định

