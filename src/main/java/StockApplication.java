import java.sql.SQLException;
import java.util.Map;

public class StockApplication {

    public static void main(String[] args) {
        StockService stockService = new StockService();

        for (Map.Entry entry : stockService.stockPrice.entrySet())
        {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }



    }
}