/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        System.out.println("\n<-- Starting test -->"); 
    }

    @Test
    public void testOrderHistory() {
        OrderDao orderDao = new OrderDao(mongoClient);
        List<Order> o = orderDao.listOrder("5f6f86ef38d82e0bd78f9e35");
         assertNotNull("Testing Order History",o);
        for(Order i:o)
            System.out.println(i);
        System.out.println("Order Histroy Test Succeed");  
    }
 
    @Test
    public void testLinkedSmartCardList() {
        SmartCardDao smartCardDao = new SmartCardDao(mongoClient);
        List<SmartCard> o = smartCardDao.listLinkedSmartCard("5f7067cb618a4834749e1f7d");
         assertNotNull("Testing Linked Smart Card List ",o);
            System.out.println("Getting the linked smart card");
             System.out.println(o);
            System.out.println("Linked Smart Card List Test Succeed");
    }
    
}
