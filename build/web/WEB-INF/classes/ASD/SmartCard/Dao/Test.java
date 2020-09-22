/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author daohuxia
 */

public class Test {
    //插入多个文档
    public static void main(String args[]){
         //获取数据库连接对象
    MongoDatabase mongoDatabase = MongoDBUtils.getConnect();
    //获取集合
    MongoCollection<Document> collection = mongoDatabase.getCollection("user");
    //要插入的数据
    List<Document> list = new ArrayList<>();
    for(int i = 1; i <= 3; i++) {
        Document document = new Document("name", "张三")
                .append("sex", "男")
                .append("age", 18);
        list.add(document);
    }
    //插入多个文档
    collection.insertMany(list);
    }


    
}
