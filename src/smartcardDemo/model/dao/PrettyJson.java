package smartcardDemo.model.dao;

import org.bson.Document;
import org.json.JSONObject;

public class PrettyJson {

	public PrettyJson() {

	}

	public static void printJSON(Document obj) {
		JSONObject jsonObject = new JSONObject(obj);
		String prettyJson = jsonObject.toString(4);
		System.out.println(prettyJson);
	}

}
