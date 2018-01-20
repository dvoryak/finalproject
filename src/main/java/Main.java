import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        String s_date = "Jan 3, 2018";

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        System.out.println(dateFormat.parse(s_date));
    }
}
