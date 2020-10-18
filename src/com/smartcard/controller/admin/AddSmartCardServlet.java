package com.smartcard.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.MongoUtils;
import com.smartcard.entity.SmartCard;
import com.smartcard.service.SmartCardService;

@WebServlet("/Add_SmartCard")
public class AddSmartCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SmartCardService scService = new SmartCardService();
	MongoDatabase database = MongoUtils.getMongoDB();

	public AddSmartCardServlet() {
		super();
	}
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.getRequestDispatcher("/smartcard.jsp").forward(request, response);
//
////        RequestDispatcher  dispatcher = request.getRequestDispatcher("/registration.jsp");
////        dispatcher.forward(request, response);
//	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create new card
		SmartCard sc = new SmartCard();

		sc.setCardNumber(sc.getCardNumber());
		
		scService.create(sc);

		request.getRequestDispatcher("/index.jsp").forward(request, response);

//        String  smartCardType=req.getParameter("smartCardType");
//        
//        Random r = new Random();
//        StringBuilder rs = new StringBuilder();
//        for (int i = 0; i < 16; i++) {
//             rs.append(r.nextInt(9));
//         }
//         String smartCardNumber = rs.toString();
//        
//         Random rr = new Random();
//        StringBuilder rrs = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//             rrs.append(rr.nextInt(9));
//         }
//         String securityCode = rrs.toString();
//         
//        MongoDatabase database = Util.getConnect();
//        MongoCollection<Document> collection = database.getCollection("SmartCard");
//        
//        Document document = new Document();
//   
//            document.append("smartCardNumber",smartCardNumber);
//            document.append("securityCode",securityCode);
//            document.append("userId","empty");
//            document.append("smartCardType",smartCardType);
//            document.append("smartCardBalance","0.00");
//            document.append("smartCardStatus","active");
//    
//         collection.insertOne(document);	
//             
//     req.setAttribute("smartCardNumber", smartCardNumber);
//     req.setAttribute("securityCode", securityCode);
//     req.setAttribute("smartCardType", smartCardType);
//
//     req.getRequestDispatcher("/smartCardDetail.jsp").forward(req, resp);
//	}

	}
}
