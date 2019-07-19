package ca.teranet.steps.base;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReportSteps {

	private static String currentTestName;
	private static Date startDate;
	private static long responseTime = 0;

	private static Document doc;

	private static Node caseNode;
	private static Node resultNode;
	private static Node currentNode;

	private String report_folder = "C:\\report\\";
	private SimpleDateFormat dateFormat_report = new SimpleDateFormat("d/M/yyyy - h:m:s", Locale.ENGLISH);

	@Given("user starts $testName")
	public void user_create_xml_report(String testName) {
		currentTestName = testName;
		create_xml_report();
		// heavyTestStep.reSetBulkInstName();
	}

	private void create_xml_report() {

		String[] testInfos = null;
		testInfos = currentTestName.split("-");

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			doc = docBuilder.newDocument();

			String reportName = "Report";
			Node reportNode = doc.createElement(reportName);
			doc.appendChild(reportNode);

			caseNode = doc.createElement("testCase");
			reportNode.appendChild(caseNode);

			Node subNode = doc.createElement("testCaseName");
			subNode.appendChild(doc.createTextNode(testInfos[1]));
			caseNode.appendChild(subNode);

			subNode = doc.createElement("startTime");
			subNode.appendChild(doc.createTextNode(dateFormat_report.format(new Date())));
			caseNode.appendChild(subNode);

			subNode = doc.createElement("status");
			subNode.appendChild(doc.createTextNode("PASSED"));
			caseNode.appendChild(subNode);

			subNode = doc.createElement("timeTaken");
			subNode.appendChild(doc.createTextNode("0"));
			caseNode.appendChild(subNode);

			resultNode = doc.createElement("testResults");
			reportNode.appendChild(resultNode);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		user_save_xml_report();
	}

	@Then("log failure and save report")
	public void log_xml_report_failed() {
		NodeList nodes;

		nodes = ((Element) caseNode).getElementsByTagName("status");
		nodes.item(0).setTextContent("FAILED");

		user_save_xml_report();
	}

	@Then("user ends test")
	public void user_save_xml_report() {
		NodeList nodes;

		try {
			nodes = ((Element) caseNode).getElementsByTagName("startTime");
			String testStartTime = nodes.item(0).getTextContent();

			nodes = ((Element) caseNode).getElementsByTagName("timeTaken");

			Date testStartDate = dateFormat_report.parse(testStartTime);
			Date endDate = new Date();
			long timeTaken = endDate.getTime() - testStartDate.getTime();

			nodes.item(0).setTextContent(Long.toString(timeTaken));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		save_xml_report();
	}

	private void save_xml_report() {

		String report_path = "";
		String[] testInfos = null;
		testInfos = currentTestName.split("-");

		report_path = report_folder + testInfos[0];
		File theDir = new File(report_path);

		if (!theDir.exists()) {
			try {
				theDir.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		report_path = report_path + "\\" + testInfos[1] + ".xml";
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(report_path));

			transformer.transform(source, result);
			System.out.println("File saved!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("user adds transaction name: $transactionName")
	@When("user adds transaction name: $transactionName")
	@Then("user adds transaction name: $transactionName")
	public void user_add_transaction_name_log(String transactionName) {
		append_test_results_node("Transaction", "name", transactionName);
	}

	@Given("user adds step name: $stepName")
	@When("user adds step name: $stepName")
	@Then("user adds step name: $stepName")
	public void user_add_step_name_log(String stepName) {
		append_test_results_node("Step", "name", stepName);
	}

	@When("user begins to record {transaction|step} start time")
	@Then("user begins to record {transaction|step} start time")
	public void user_begin_record_timestamp_log() {
		startDate = new Date();
		append_test_results_subNode("StartTime", dateFormat_report.format(startDate));
	}

	@When("user records {transaction|step} reponse time")
	@Then("user records {transaction|step} reponse time")
	public void user_end_record_timestamp_log() {
		Date endDate = new Date();
		responseTime = endDate.getTime() - startDate.getTime();
		append_test_results_subNode("ResponseTime", Long.toString(responseTime));

		// long diffSeconds = diff / 1000 % 60;
		// long diffMinutes = diff / (60 * 1000) % 60;
		// long diffHours = diff / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);
	}

	private void append_test_results_node(String tagName, String tagAttr, String tagValue) {

		currentNode = doc.createElement(tagName);
		resultNode.appendChild(currentNode);

		Attr attr = doc.createAttribute(tagAttr);
		attr.setValue(tagValue);
		((Element) currentNode).setAttributeNode(attr);
	}

	private void append_test_results_subNode(String tagName, String tagValue) {

		Node subNode = doc.createElement(tagName);
		subNode.appendChild(doc.createTextNode(tagValue));
		currentNode.appendChild(subNode);
	}
}
