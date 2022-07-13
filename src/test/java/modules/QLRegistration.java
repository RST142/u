package modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.GetExcelData;
import utilities.GlobalUtil;

public class QLRegistration {

	static Connection con = null;
	static Statement stmt = null;

	static String username;
	static String password;
	static String dbUrl;
	static String env;

	public static String sqlConnection(String otp) throws ClassNotFoundException, SQLException {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");
		String query = "select * from ql_user_validation;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(dbUrl + "/ql", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(5);
				System.out.println(otp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}

	public static String forgotPasswordConnection(String otp) throws ClassNotFoundException, SQLException {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");
		String query = "select * from ql_forgot_password;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(dbUrl + "/ql", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(5);
				System.out.println(otp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}
	
	public static String emailverificationOTP(String otp, String email) {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");

		String query = "select * from email_verification where email_address=\""+email+ "\";";

		System.out.println(query);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println(dbUrl + "njjhkjbhb");
			con = DriverManager.getConnection(dbUrl + "/pwms", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(4);
				System.out.println(otp + "findingotp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}
	
	public static String phoneverificationOTP(String otp, String phone) {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");

		String query = "select * from phone_verification where phone_number=\""+phone.toString()+ "\";";

		System.out.println(query);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(dbUrl + "/pwms", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(5);
				System.out.println(otp + "findingotp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}

	public static String EmailOTPConnection(String otp, String user) throws ClassNotFoundException, SQLException {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");

		String query = "select * from change_password_verification where user_id=\"" + user
				+ "\" and otp_type=\"Email_Authentication\" and tenant_domain=\"" + GlobalUtil.domainname + "\";";

		System.out.println(query);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println(dbUrl);
			con = DriverManager.getConnection(dbUrl + "/pwms", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(6);
				System.out.println(otp + "findingotp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}

	public static String PhoneOTPMessageConnection(String otp, String user)
			throws ClassNotFoundException, SQLException {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");
		String query = "select * from change_password_verification where user_id=\"" + user
				+ "\" and otp_type=\"Phone_Authentication\" and tenant_domain=\"" + GlobalUtil.domainname + "\";";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(dbUrl + "/pwms", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(6);
				System.out.println(otp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}
	public static String MobilePushOTPMessageConnection(String otp, String user)
			throws ClassNotFoundException, SQLException {

		env = GlobalUtil.Environment;

		dbUrl = GlobalUtil.getdbinfo().get(env + "dbUrl");
		username = GlobalUtil.getdbinfo().get(env + "username");
		password = GlobalUtil.getdbinfo().get(env + "password");
		String query = "select * from change_password_verification where user_id=\"" + user
		//		+ "\" and otp_type=\"Unifyed_Mobile_Push_Authentication\" ;";
		+ "\" and otp_type=\"Unifyed_Mobile_Push_Authentication\" and tenant_domain=\"" + GlobalUtil.domainname + "\";";

		System.out.println(query + "query");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(dbUrl + "/pwms", username, password);

			stmt = con.createStatement();

			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				otp = rs.getString(6);
				System.out.println(otp + "Mobile push Otp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;

	}
	
}
