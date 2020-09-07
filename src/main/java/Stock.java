
public class Stock {

    int stockId;
    String stockName;
    int quantity;



    public Stock(int stockId, String stockName, int quantity) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.quantity = quantity;
    }



    /**
     * Constructor
     */
    public Stock() {
    }

    /**
     * Gets the stockId
     */
    public int getStockId() {
        return this.stockId;
    }

    /**
     * Sets the stockId
     */
    public void setStockId(int value) {
        this.stockId = value;
    }

    /**
     * Gets the stockName
     */
    public String getStockName() {
        return this.stockName;
    }

    /**
     * Sets the stockName
     */
    public void setStockName(String value) {
        this.stockName = value;
    }

    /**
     * Gets the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }
}