/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

/**
 *
 * @author Patty
 */
import org.bson.Document;
import org.json.*;

public class PrettyJson {

    public static void printJSON(Document obj) {
        JSONObject jsonObject = new JSONObject(obj);
        String prettyJson = jsonObject.toString(4);
        System.out.println(prettyJson);
    }
}

