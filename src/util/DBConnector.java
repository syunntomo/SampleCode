package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	public static String driverManager = "oracle.jdbc.driver.OracleDriver";
	public static String user = "system";
	public static String password = "Syunntomo1991";
	public static String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	//自分がDBのコネクションに使用するメソッドを規定する
	public Connection getConnection() {

		Connection con = null;

		try {
			/*Class.forName() java.sql.Driver interfaceの実装クラス
			 *DriverのクラスイニシャライザにDriver自身をDriverManagerを登録する処理があり、それを実行する*/
			Class.forName(driverManager);
			/*DriverManager.getConnection(url, user, password) throws SQLException
			 *APIに定義されているメソッドであり、これを使うためにフィールドに準備している
			 *また、オーバーロードで引数がurlのみのものもある*/
			con = DriverManager.getConnection(url, user, password);
		}
		//Class.forNameのthrowsに対応
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//getConnection()のthrowsに対応
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
