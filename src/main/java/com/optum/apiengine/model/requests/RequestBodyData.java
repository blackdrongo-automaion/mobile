package com.optum.apiengine.model.requests;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RequestBodyData {

    public static JsonPath path;
    public String JsonFilePath;

    public RequestBodyData(String JsonFilePath) {
        this.JsonFilePath = JsonFilePath;

    }

    public RequestBodyData() {
    }

    public Object data(String testID) {
        path = new JsonPath(new File(RequestBodyData.class.getClassLoader().getResource(this.JsonFilePath ).getFile()));
        return path.get(testID);
    }

    public String updateRallyJsonValues(String[] rallyId, String verd){
        JSONParser jsonParser = new JSONParser();
        JSONObject testCaseResult = null;
        try (FileReader reader = new FileReader(RequestBodyData.class.getClassLoader().getResource(this.JsonFilePath).getFile())) {
            Object obj = jsonParser.parse(reader);
            JSONObject employeeList = (JSONObject) obj;
            testCaseResult = (JSONObject) employeeList.get("TestCaseResult");
            JSONObject testCase = (JSONObject) testCaseResult.get("TestCase");
            testCase.put("_ref", rallyId);
            testCaseResult.put("Verdict", verd);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return testCaseResult.toString();
    }
}
