import entity.Order;
import entity.SmartCard;
import dao.OrderDao;
import dao.SmartCardDao;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yike8
 */
public class JUnitTest {
  private static MongoClient mongoClient;  
    public JUnitTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        String dbUri = "mongodb://hugh:hugh990104@ds011288.mlab.com:11288/heroku_lcjwqk0m";
        mongoClient = new MongoClient(new MongoClientURI(dbUri));
        System.out.println("\n<-- database connection success -->"); 
    }

    @Test
    public void testOrderHistory() {
        OrderDao orderDao = new OrderDao(mongoClient);
        List<Order> o = orderDao.listOrder("5f6f86ef38d82e0bd78f9e35");
         assertNotNull("Testing Adding Reports",o);
        System.out.println("Reportinh Test Succeed");  
    }
 
    @Test
    public void testLinkedSmartCardList() {
        SmartCardDao smartCardDao = new SmartCardDao(mongoClient);
        List<SmartCard> o = smartCardDao.listLinkedSmartCard("5f7067cb618a4834749e1f7d");
         assertNotNull("Testing report withdraw",o);
            System.out.println("Getting the Report withdrawed");
             System.out.println(o);
            System.out.println("Report withdraw function Test Succeed");
    }
    
}
