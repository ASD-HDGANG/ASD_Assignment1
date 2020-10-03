package smartcardDemo.service;

import java.io.File;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

import smartcardDemo.dao.CustomerDAO;
import smartcardDemo.dao.SmartCardDAO;
import smartcardDemo.dao.dBUtils;
import smartcardDemo.entity.SmartCard;

public class SmartcardService {

	SmartCardDAO smartCardDAO = new SmartCardDAO();

	public SmartcardService() {
	}

	public SmartcardService(SmartCardDAO smartCardDAO, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.smartCardDAO = smartCardDAO;
	}

	public void create(SmartCard smartcard) throws UnknownServiceException, ServletException, IOException {

		// String smartCardType = request.getParameter("smartCardType");
		getSmartCardNumber();
		getSecurityCode();

		MongoDatabase database = dBUtils.getMongoDB();
		MongoCollection<Document> scTbl = database.getCollection("SmartCard_test");

		Document scDoc = new Document();

		scDoc.append("smartCardNumber", smartcard.getCardNumber());
		scDoc.append("securityCode", smartcard.getSecurityCode());
		scDoc.append("userId", "empty");
		// scDoc.append("smartCardType", smartCardType);
		scDoc.append("smartCardBalance", "0.00");
		scDoc.append("smartCardStatus", "active");

		scTbl.insertOne(scDoc);

	}

	public void viewSmartCardDetail() throws ServletException, IOException {

//		public List<SmartCard> listLinkedSmartCard(String userId) {
//		 List<SmartCard> list = new ArrayList<>();
//              for (Document doc : collection.find()) {
//	       if (((String) doc.get("userId")).equals(userId)) {
//			       SmartCard smartCard = new SmartCard(null,null,userId,null,null,null);
//				smartCard.setCardNumber((String)doc.get("smartCardNumber"));
//				smartCard.setSecurityCode((String)doc.get("securityCode"));
//                               smartCard.setCardType((String)doc.get("smartCardType"));
//                               smartCard.setCardBalance((String)doc.get("smartCardBalance"));
//                               smartCard.setCardStatus((String)doc.get("smartCardStatus"));
//				list.add(smartCard); 
//			}
//		}  
//		return list;
//	}
//

	}

	public void getSmartCardNumber() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(9));
		}
		String cardNumber = sb.toString();
	}

	public void getSecurityCode() {
		Random rand = new Random();
		StringBuilder rrs = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			rrs.append(rand.nextInt(9));
		}
		String securityCode = rrs.toString();
	}

//	public void saveImg(DB db) throws IOException {
//		MongoDatabase mdb = (MongoDatabase) dBUtils.getMongoDB();
//
//		String newFileName = "adult";
//		File imagePath = new File("D:/Users/Patty/eclipse-workspace/smartcardDemo/WebContent/img/adult.jpg");
//		GridFS gfsImg = new GridFS(db, "image");
//		try {
//			GridFSInputFile gfsFile = gfsImg.createFile(imagePath);
//			gfsFile.setFilename(newFileName);
//			gfsFile.save();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

}
