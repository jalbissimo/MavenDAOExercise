import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAOImplementation implements StockDAO {
   public  List<Stock> stocks;


    public StockDAOImplementation()  {
        stocks = new ArrayList<Stock>();
       /* Stock student1 = new Stock(1,"Robert",0);
        Stock student2 = new Stock(2,"John",1);
        stocks.add(student1);
        stocks.add(student2);*/

        populateStockList();

    }
    @Override
    public Stock getItemFromStock(long stockId) {
        return null;
    }
    private void populateStockList()  {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try
        {
            C3P0ConnectionManager dataSource = C3P0ConnectionManager.getInstance();
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM stock");
            //System.out.println("The Connection Object is of Class: " + connection.getClass());
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
               stocks.add(new Stock(Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(2).toString(),Integer.parseInt(resultSet.getString(3))));

            }

        }
        catch (Exception e)
        {
            //connection.rollback();
            e.printStackTrace();
        }
    }

}
