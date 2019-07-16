package ca.teranet.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTLib {
	private String baseURL = "";
	private String contentType = "";
	private Integer portNumber = 0;
	private String userID = "";
	private String password = "";

	// Content Type - "application/json";

	public RESTLib(String curr_BaseURL, String curr_contentType, String curr_portNumber, String curr_userID, String curr_password) {
		baseURL = curr_BaseURL;
		// TO_DO Content Type should be Enumerator
		contentType = curr_contentType;
		portNumber = Integer.parseInt(curr_portNumber);
		userID = curr_userID;
		password = curr_password;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String curr_BaseURL) {
		baseURL = curr_BaseURL;
	}

	/**
	 * Basic Request builder
	 * 
	 * @return
	 *
	 */
	public RequestSpecification Request(RequestSpecification rs) {
		rs = RestAssured.given();
		if (baseURL.contains("https")) {
			rs = rs.relaxedHTTPSValidation();
			rs.port(portNumber);
		}
		return rs;
	}

	/**
	 * get Operation with Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification getRequestBuilder(RequestSpecification rs, Map<String, String> headers) {
		rs = Request(rs);
		rs = rs.contentType(contentType);
		if (headers != null) {
			Set<String> headerKeys = headers.keySet();
			for (String headerKey : headerKeys)
				rs.header(headerKey, headers.get(headerKey));
		}
		return rs;
	}

	/**
	 * get Operation without Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification getRequestBuilder(RequestSpecification rs) {
		rs = Request(rs);
		rs = rs.contentType(contentType);
		return rs;
	}

	/**
	 * get Operation with Headers and parameters
	 * 
	 * @return
	 *
	 */
	public RequestSpecification getRequestBuilder(RequestSpecification rs, Map<String, String> headers, Map<String, ?> parametersMap) {
		rs = getRequestBuilder(rs, headers);
		if (parametersMap != null) {
			rs.params(parametersMap);
		}
		return rs;
	}

	/**
	 * Secured get Operation with Username, Password and Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification getRequestBuilder(RequestSpecification rs, String Username, String Password, Map<String, String> headers) {
		if (baseURL.contains("https")) {
			rs = RestAssured.given();
			rs = rs.auth().preemptive().basic(Username, Password);
			rs.port(portNumber);
		} else {
			rs = RestAssured.given().auth().preemptive().basic(Username, Password);
		}
		rs.header("Content-Type", contentType);
		if (headers != null) {
			Set<String> headerKeys = headers.keySet();
			for (String headerKey : headerKeys)
				rs.header(headerKey, headers.get(headerKey));
		}
		return rs;
	}

	/**
	 * post Operation with headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, Map<String, String> headers) {
		rs = Request(rs);
		rs = rs.contentType(contentType);
		if (headers != null) {
			Set<String> headerKeys = headers.keySet();
			for (String headerKey : headerKeys)
				rs.header(headerKey, headers.get(headerKey));
		}
		return rs;
	}

	/**
	 * post Operation with Body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, String Body) {
		rs = Request(rs);
		rs = rs.contentType(contentType);
		if (Body != null) {
			// ExtentTestManager.getTest().info("Request Body is " + Body);
			rs = rs.body(Body);
		}
		return rs;
	}

	/**
	 * post Operation with Headers and body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, Map<String, String> headers, String body) {
		rs = postRequestBuilder(rs, headers);
		if (body != null) {
			rs = rs.body(body);
		}
		return rs;
	}

	/**
	 * post Operation with Headers and Parameters
	 * 
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, Map<String, String> headers, Map<String, String> parametersMap) {
		rs = postRequestBuilder(rs, headers);
		if (parametersMap != null) {
			rs.params(parametersMap);
		}
		return rs;
	}

	/**
	 * Secured post Operation with Username, Password and Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, String Username, String Password, Map<String, String> headers) {
		if (baseURL.contains("https")) {
			RestAssured.baseURI = baseURL; // + ":" + portNumber.toString();
			rs = RestAssured.given().contentType(contentType).relaxedHTTPSValidation().auth().preemptive().basic(Username, Password).port(portNumber).baseUri(baseURL);
		} else {
			rs = RestAssured.given().auth().preemptive().basic(Username, Password);
		}
		// rs.header("Content-Type", "application/json");
		if (headers != null) {
			Set<String> headerKeys = headers.keySet();
			for (String headerKey : headerKeys)
				rs.header(headerKey, headers.get(headerKey));
		}
		return rs;
	}

	/**
	 * Secured put Operation with Username, Password and Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, String Username, String Password, Map<String, String> headers, String body) {
		rs = postRequestBuilder(rs, Username, Password, headers);
		if (body != null) {
			rs.body(body);
		}

		return rs;
	}

	/**
	 * Secured put Operation with Username, Password and Headers
	 * 
	 * @return
	 *
	 */
	public Response postRequestBuilderAndPost(RequestSpecification rs, String Username, String Password, Map<String, String> headers, String body, String Resource) {
		rs = postRequestBuilder(rs, Username, Password, headers, body);
		Response rp = performPOSTOperation(rs, Resource);
		return rp;
	}

	/**
	 * post Operation with Headers, Parameters and body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, Map<String, String> headers, Map<String, ?> parametersMap, String body) {
		rs = postRequestBuilder(rs, headers, body);
		if (parametersMap != null) {
			rs.params(parametersMap);
		}
		return rs;
	}

	/**
	 * Encoded Content Type
	 * 
	 * @return
	 *
	 */

	public RequestSpecification EncodedUrl(RequestSpecification rs, boolean urlencodedForm) {
		if (urlencodedForm) {
			rs.config(RestAssured.config()
					.encoderConfig(EncoderConfig.encoderConfig()
							.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)));
		}
		return rs;
	}

	/**
	 * Post Operation with Encoded Url and Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, boolean urlencodedForm, Map<String, String> headers) {
		rs = Request(rs);
		rs = EncodedUrl(rs, urlencodedForm);
		rs = rs.contentType(contentType);
		if (headers != null) {
			Set<String> headerKeys = headers.keySet();
			for (String headerKey : headerKeys)
				rs.header(headerKey, headers.get(headerKey));
		}
		return rs;
	}

	/**
	 * post Operation with Encoded Url, Headers and body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, boolean urlencodedForm, Map<String, String> headers, String Body) {
		rs = postRequestBuilder(rs, urlencodedForm, headers);
		if (Body != null) {
			rs = rs.body(Body);
		}
		return rs;
	}

	/**
	 * post Operation with Encoded Url, Headers and body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification postRequestBuilder(RequestSpecification rs, boolean urlencodedForm, String Body) {
		rs = Request(rs);
		rs = EncodedUrl(rs, urlencodedForm);
		rs = rs.contentType(contentType);
		if (Body != null) {
			rs = rs.body(Body);
		}
		return rs;
	}

	/**
	 * put Operation with body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification putRequestBuilder(RequestSpecification rs, String Body) {
		rs = postRequestBuilder(rs, Body);
		return rs;
	}

	/**
	 * put Operation with Headers and body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification putRequestBuilder(RequestSpecification rs, Map<String, String> headers, String Body) {
		rs = postRequestBuilder(rs, headers, Body);
		return rs;
	}

	/**
	 * put Operation with Username, Password and body
	 * 
	 * @return
	 *
	 */
	public RequestSpecification putRequestBuilder(RequestSpecification rs, String Username, String Password, String Body) {
		if (baseURL.contains("https")) {
			rs = RestAssured.given().auth().preemptive().basic(Username, Password);
			rs.port(portNumber);
		} else {
			rs = RestAssured.given().auth().preemptive().basic(Password, Password);
		}
		rs.header("Content-Type", "application/json");
		rs.body(Body);
		return rs;
	}

	/**
	 * Delete Operation
	 * 
	 * @return
	 *
	 */
	public RequestSpecification deleteRequestBuilder(RequestSpecification rs) {
		rs = Request(rs);
		rs = rs.contentType(contentType);
		return rs;
	}

	/**
	 * Delete Operation with Headers and Parameters
	 * 
	 * @return
	 *
	 */
	public RequestSpecification deleteRequestBuilder(RequestSpecification rs, Map<String, String> headers, Map<String, ?> parametersMap) {
		rs = getRequestBuilder(rs, headers, parametersMap);
		return rs;
	}

	/**
	 * Delete Operation with Headers
	 * 
	 * @return
	 *
	 */
	public RequestSpecification deleteRequestBuilder(RequestSpecification rs, Map<String, String> headers) {
		rs = getRequestBuilder(rs, headers);
		return rs;
	}

	public RequestSpecification serviceRequest(RequestSpecification rs, Map<String, String> headers, Map<String, ?> parametersMap, String body) {
		rs = RestAssured.given();
		if (baseURL.contains("https")) {
			rs = rs.relaxedHTTPSValidation();
			rs.port(portNumber);
		}
		rs = rs.contentType(contentType);
		if (headers != null) {
			Set<String> headerKeys = headers.keySet();
			for (String headerKey : headerKeys)
				rs.header(headerKey, headers.get(headerKey));
		}
		if (parametersMap != null) {
			rs.params(parametersMap);
		}
		if (body != null) {
			rs = rs.body(body);
		}
		return rs;
	}

	public Response performGETOperation(RequestSpecification rs, String Resource, String TestParameters) {
		Response rp = null;
		String url = baseURL + "/" + Resource + "/" + TestParameters;
		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().get(url);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public Response performPOSTOperation(RequestSpecification rs, String Resource, String TestParameters) {
		Response rp = null;
		String url = baseURL;
		if (Resource.length() > 0) {
			url = url + "/" + Resource + "/";
		}
		if (TestParameters.length() > 0) {
			url = url + "/" + TestParameters;
		}
		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().post(url);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public Response performPOSTOperation(RequestSpecification rs, String Resource) {
		Response rp = null;

		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().post(Resource);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public Response performPUTOperation(RequestSpecification rs, String Resource, String TestParameters) {
		Response rp = null;
		String url = baseURL;
		if (Resource.length() > 0) {
			url = url + "/" + Resource + "/";
		}
		if (TestParameters.length() > 0) {
			url = url + "/" + TestParameters;
		}
		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().put(url);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public Response performPUTOperation(RequestSpecification rs, String Resource, String TestParameters, String Key) {
		Response rp = null;
		String url = baseURL + "/" + Resource + "/" + TestParameters + Key;
		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().put(url);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public Response performDELETEOperation(RequestSpecification rs, String Resource, String TestParameters) {
		Response rp = null;
		String url = baseURL + "/" + Resource + "/" + TestParameters;
		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().delete(url);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public Response performPATCHOperation(RequestSpecification rs, String Resource, String TestParameters) {
		Response rp = null;
		String url = baseURL + "/" + Resource + "/" + TestParameters;
		// ExtentTestManager.getTest().info("Request is " + url);
		rp = rs.when().patch(url);
		// ExtentTestManager.getTest().info("Response is " + rp.asString());
		return rp;
	}

	public String getResponseVal(Response rp) {
		String ResponseVal = "";
		ResponseVal = rp.then().extract().response().asString();
		return ResponseVal;
	}

	public int getResponseStatusCode(Response rp) {
		int responseCode;
		responseCode = rp.getStatusCode();
		return responseCode;
	}

	public String getResponseHeaders(Response rp) {
		String respHeaders = "";
		respHeaders = rp.getHeaders().toString();
		return respHeaders;
	}

	public String getResponseINXML(Response rp) {
		String xmlResponse;
		xmlResponse = rp.then().extract().response().xmlPath().toString();
		return xmlResponse;
	}

	public int getStatusCode(Response rp) {
		return rp.getStatusCode();
	}

	public int getNodeCount(Response rp, String nodeName) {

		List<String> jsonResponse = rp.jsonPath().getList(nodeName);

		System.out.println(jsonResponse.size());

		return jsonResponse.size();
	}

	public List<String> getListValues(Response rp, String nodeName) {

		List<String> usernames = rp.jsonPath().getList(nodeName);
		System.out.println(usernames);
		return usernames;

	}

	public String getMapValues(Response rp, String nodeName, String key) {

		Map<String, String> company = rp.jsonPath().getMap(nodeName);
		System.out.println(company.get(key));
		return nodeName;

	}

	public String getNodeValue(Response rp, String nodeName) {
		String NodeValues = rp.jsonPath().getString(nodeName);
		System.out.println(NodeValues);
		return NodeValues;
	}

}
