import java.util.HashMap;

public class StockService {
    public HashMap<String,Integer> stockPrice = new HashMap<>() ;
    public StockService(){
        generatePrice();
    }
    private void generatePrice(){
        StockDAO studentDao = new StockDAOImplementation();
        for (int i = 0; i <((StockDAOImplementation) studentDao).stocks.size() ; i++) {
                stockPrice.put(((StockDAOImplementation) studentDao).stocks.get(i).getStockName(),priceAlghoritm(((StockDAOImplementation) studentDao).stocks.get(i).getQuantity()));

        }
    }
    private int priceAlghoritm(int quantity){
        return quantity*2;
    }
}
