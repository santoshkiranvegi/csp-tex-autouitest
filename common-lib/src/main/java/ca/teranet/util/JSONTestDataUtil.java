package ca.teranet.util;

import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author SKarnati
 *
 */

public class JSONTestDataUtil {
	static Iterator JSArrItr;

	/**
	 * @testDataSetup, This method helps to read the data JSON file based on the Provided Array Name Input Parameters: JSONFileName(Class Name) and Array Name
	 */
	public static void testDataSetup(String JSONFilePath, String JSONArrayName) {
		try {
			FileReader reader;
			String FileName = JSONFilePath;
			reader = new FileReader(FileName);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray JSArray = (JSONArray) jsonObject.get(JSONArrayName);
			for (int iArrLoop = 0; iArrLoop < JSArray.size(); iArrLoop++) {
				System.out.println("The " + iArrLoop + " element of the array: " + JSArray.get(iArrLoop));
			}
			JSArrItr = JSArray.iterator();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @getData, This method helps to build a hashmap (Key pair) data based of the Provided JSON File Name, JSON Array Name and Header/body/normal Parameters Input Parameters: JSONFileName(Class Name),Array Name and Header/Body/OnlyParams(Refer API Constants)
	 */
	public static HashMap<String, String> getData(String JSONFileName, String JSONArrayName, String Parameters) {
		testDataSetup(JSONFileName, JSONArrayName);
		String ScriptName = Thread.currentThread().getStackTrace()[2].getMethodName();
		// ScriptName= ExtentTestManager.getMethod();
		while (JSArrItr.hasNext()) {

			JSONObject innerObj = (JSONObject) JSArrItr.next();
			String TestScriptName = (String) innerObj.get("TestScriptName");
			System.out.println("TestscriptName is " + TestScriptName);

			if (TestScriptName.contentEquals(ScriptName)) {
				JSONArray ParamSearch = (JSONArray) innerObj.get(Parameters);
				for (int iParamLoop = 0; iParamLoop < ParamSearch.size(); iParamLoop++) {
					System.out.println("The " + iParamLoop + " element of the array: " + ParamSearch.get(iParamLoop));
				}

				Iterator JSArrParam = ParamSearch.iterator();
				JSONObject IndvlJSArrParam = (JSONObject) JSArrParam.next();

				Collection<String> keys = IndvlJSArrParam.keySet();
				HashMap<String, String> Params = new HashMap<>();
				for (String key : keys) {
					Params.put(key.toString(), IndvlJSArrParam.get(key).toString());
				}
				System.out.println(keys.toString());
				return Params;
			}
		}
		return null;
	}
}
