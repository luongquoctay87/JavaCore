package src;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
//        Locale defaultLocal = Locale.getDefault();

//        System.out.println("-----[ Print default language ]-----");
//
//        System.out.println("getCountry(): "+ defaultLocal.getCountry());
//        System.out.println("getDisplayCountry(): "+ defaultLocal.getDisplayCountry());
//
//        System.out.println("getLanguage(): " + defaultLocal.getLanguage());
//        System.out.println("getDisplayLanguage(): " + defaultLocal.getDisplayLanguage());
//
//        System.out.println("getDisplayName(): "+ defaultLocal.getDisplayName());
//
//        System.out.println("getISO3Country(): " + defaultLocal.getISO3Country());
//        System.out.println("getISO3Language(): "+ defaultLocal.getISO3Language());


        // Chuyển từ tiếng việt sang ngôn ngữ khác
//        Locale vnLocale = new Locale("vi", "VN");
//        Locale chinaLocale = Locale.CHINA;
//        Locale japanLocale = Locale.JAPAN;
//
//        System.out.println("getDisplayLanguage(): " + vnLocale.getDisplayLanguage());
//        System.out.println("getDisplayLanguage(vnLocale): " + vnLocale.getDisplayLanguage(vnLocale));
//
//        System.out.println("CHINA: " + chinaLocale.getDisplayLanguage());  // print Chinese
//        System.out.println("CHINA: " + chinaLocale.getDisplayLanguage(vnLocale)); // print Tiếng Trung
//        System.out.println("JAPAN: " + japanLocale.getDisplayLanguage()); // Japanese
//        System.out.println("JAPAN: " + japanLocale.getDisplayLanguage(vnLocale)); // Tiếng Nhật

//        // Hiển thị ngôn ngữ từ nhiều local
//        Locale[] locales = {new Locale("en", "GB"), new Locale("fr", "FR"), new Locale("es", "ES")};
//        for (int i = 0; i < locales.length; i++) {
//            String displayLanguage = locales[i].getDisplayLanguage(locales[i]);
//            System.out.println(locales[i] + ": " + displayLanguage);
//        }

        // Internationalizing Currency
//        NumberFormat vnFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
//        NumberFormat jpyFormatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
//        NumberFormat usdFormatter = NumberFormat.getCurrencyInstance(Locale.US);
//
//        String vnd = vnFormatter.format(10500.3245);
//        String jpy = jpyFormatter.format(10500.3245);
//        String usd = usdFormatter.format(10500.3245);
//
//        System.out.println("vnđ: " + vnd);
//        System.out.println("jpy: " + jpy);
//        System.out.println("usd: " + usd);

        // Internationalizing date
//        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
//        Date currentDate = new Date();
//        String date = formatter.format(currentDate);
//        System.out.println(date);

        // Internationalizing Time
//        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.getDefault());
//        Date currentDate = new Date();
//        String time = formatter.format(currentDate);
//        System.out.println(time);

    }
}
