package ca.teranet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.jbehave.core.model.ExamplesTable;

public class DBUtil {

	private static String encryptedDBFile = "C:\\COMMON-LIB\\selenium\\projects\\common-lib\\RAPID_DB.enc";
	private static String strDecryptedDB = "";
	private static String connStrProd = "";
	private static String connStrDev = "";
	private static String username = "";
	private static String password = "";

	public static void main(String[] args) throws Exception {
		SelectSQL("UAT", "select * from CCTransaction");
		// Insert record
		// ExecSQL("insert into CCTransaction (TransactionID, RequestID, RunID, ApplicationName, TestEnvironment, TransactionAmount, TransactionTime) values (101,1,1,'CSP','UAT',12.4,GETDATE() )");
		// Update record
		// ExecSQL("update CCTransaction set StatusCode=1, ReversedInd='Y', ReversedTime=GETDATE() where TransactionID=101");
		// Delete all record
		// ExecSQL("delete from CCTransaction");
		// SelectSQL("select * from CCTransaction");
	}

	private static void initConnString() {
		strDecryptedDB = EncryptUtil.decryptFile(encryptedDBFile);
		ExamplesTable theFieldTable = new ExamplesTable(strDecryptedDB);
		for (Map<String, String> row : theFieldTable.getRows()) {
			connStrProd = row.get("connStrProd");
			connStrDev = row.get("connStrDev");
			username = row.get("username");
			password = row.get("password");
		}
	}

	public static String SelectSQL(String env, String SQL) throws Exception {
		initConnString();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Open a connection
		Connection conn = null;
		if (env.equals("UAT")) {
			conn = DriverManager.getConnection(connStrDev, username, password);
		} else {
			conn = DriverManager.getConnection(connStrProd, username, password);
		}

		Statement stmt = conn.createStatement();
		// Execute a query
		ResultSet resultSet = stmt.executeQuery(SQL);
		System.out.println(resultSet.toString());
		String strReturn = null;

		while (resultSet.next()) {
			int numOfCols = resultSet.getMetaData().getColumnCount();
			strReturn = "|";
			for (int i = 1; i <= numOfCols; i++) {
				strReturn = strReturn + resultSet.getString(i) + "|";
			}
			strReturn = strReturn + "\r\n";
		}
		System.out.println(strReturn);

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		return strReturn;
	}

	public static void ExecSQL(String env, String SQL) throws Exception {
		initConnString();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Open a connection
		Connection conn = null;
		if (env.equals("UAT")) {
			conn = DriverManager.getConnection(connStrDev, username, password);
		} else {
			conn = DriverManager.getConnection(connStrProd, username, password);
		}
		Statement stmt = conn.createStatement();
		// Execute a query
		stmt.executeUpdate(SQL);

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
