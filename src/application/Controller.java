package application;

import java.sql.Connection;
import java.sql.DriverManager;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller extends Application {
	// 1 метод
	@FXML
	Button Connection;
	@FXML
	TextArea tf_2;

	// 2 метод

 

	@FXML
	TextField qw_1;

	@FXML
	TextField qw_2;

	
	//ввод пользователя
	@FXML
	TextField w_1;
	@FXML
	TextField w_2;
	@FXML
	TextField w_3;
	@FXML
	TextField w_4;
	@FXML
	TextField w_5;
	
	
	
	String result;

	static Connection co;

	@FXML
	void Connection2() throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		String query = "SELECT * FROM ekvaizer";

		ResultSet res = statement.executeQuery(query);
		String s = "";
		while (res.next()) {

			s +=   " Namber: " + res.getString("Namber") + "        FIO: " + res.getString("FIO")
					+ "        Model: " + res.getString("Model") + "        Nalichie: " + res.getBoolean("Nalichie")
					+ "        Oplata: " + res.getBoolean("Oplata") + "\n";

		}
		tf_2.setText(s);

	}

	@FXML
	void redNamber() throws SQLException, ClassNotFoundException {

		String nomer = qw_1.getText();

		String name = qw_2.getText();

		System.out.println(nomer + name);

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		java.sql.PreparedStatement myStmt = co

				.prepareStatement("update ekvaizer set Namber=? where FIO=?");

		myStmt.setString(1, nomer);

		myStmt.setString(2, name);

		myStmt.executeUpdate();
		Connection2();
		statement.close();
	}

	@FXML
	void redModel() throws SQLException, ClassNotFoundException {

		String nomer = qw_1.getText();

		String name = qw_2.getText();

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		java.sql.PreparedStatement myStmt = co

				.prepareStatement("update ekvaizer set Model=? where Namber=?");

		myStmt.setString(1, nomer);

		myStmt.setString(2, name);

		myStmt.executeUpdate();
		Connection2();
		statement.close();
	}

	@FXML
	void redOplata() throws SQLException, ClassNotFoundException {

		String nomer = qw_1.getText();

		String name = qw_2.getText();

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		java.sql.PreparedStatement myStmt = co

				.prepareStatement("update ekvaizer set Oplata=? where Namber=?");

		myStmt.setString(1, nomer);

		myStmt.setString(2, name);

		myStmt.executeUpdate();
		Connection2();
		statement.close();
	}

	@FXML
	void redNalichie() throws SQLException, ClassNotFoundException {

		String nomer = qw_1.getText();

		String name = qw_2.getText();

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		java.sql.PreparedStatement myStmt = co

				.prepareStatement("update ekvaizer set Nalichie=? where Namber=?");

		myStmt.setString(1, nomer);

		myStmt.setString(2, name);

		myStmt.executeUpdate();
		Connection2();
		statement.close();
	}

	@FXML
	void redKlient2a() throws SQLException, ClassNotFoundException {

		String nomer = qw_1.getText();

		String name = qw_2.getText();

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		java.sql.PreparedStatement myStmt = co

				.prepareStatement("update ekvaizer set FIO=? where Namber=?");

		myStmt.setString(1, nomer);

		myStmt.setString(2, name);

		myStmt.executeUpdate();
		Connection2();
		statement.close();
	}

	@FXML
	void poiskPoImeni() throws SQLException, ClassNotFoundException {

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		String nomer = qw_1.getText();

		java.sql.PreparedStatement myStmt = co.prepareStatement("SELECT * FROM ekvaizer WHERE FIO = ?");

		myStmt.setString(1, nomer);

		statement.close();

		ResultSet res = myStmt.executeQuery();

		String s = "";
		while (res.next()) {

			s += "        Namber: " + res.getString("Namber") + "        FIO: " + res.getString("FIO")
					+ "        Model: " + res.getString("Model") + "        Nalichie: " + res.getBoolean("Nalichie")
					+ "        Oplata: " + res.getBoolean("Oplata") + "\n";

		}
		tf_2.setText(s);

	}

	@FXML
	void nalichie() throws SQLException {

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();
		statement.close();
		 

		java.sql.PreparedStatement myStmt = co.prepareStatement ("SELECT * FROM ekvaizer WHERE Nalichie = '1'");
		ResultSet res = myStmt.executeQuery();

		String s = "";
		while (res.next()) {

			s += "        Namber: " + res.getString("Namber") + "        FIO: " + res.getString("FIO")
					+ "        Model: " + res.getString("Model") + "        Nalichie: " + res.getBoolean("Nalichie")
					+ "        Oplata: " + res.getBoolean("Oplata") + "\n";

		}
		tf_2.setText(s);
		statement.close();
	}

	@FXML
	void neoplata() throws SQLException {

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();
		statement.close();
		java.sql.PreparedStatement myStmt = co.prepareStatement ("SELECT *   FROM ekvaizer WHERE   Oplata != '1' ");

		ResultSet res = myStmt.executeQuery();
		String s = "";
		while (res.next()) {

			s += "        Namber: " + res.getString("Namber") + "        FIO: " + res.getString("FIO")
					+ "        Model: " + res.getString("Model") + "        Nalichie: " + res.getBoolean("Nalichie")
					+ "        Oplata: " + res.getBoolean("Oplata") + "\n";
		}
		tf_2.setText(s);
	}

	@FXML
	void fulse() throws SQLException {

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();

		statement.close();

		java.sql.PreparedStatement myStmt = co.prepareStatement ("SELECT * FROM ekvaizer WHERE Nalichie  != '1'");
		ResultSet res = myStmt.executeQuery();

		String s = "";
		while (res.next()) {

			s += "        Namber: " + res.getString("Namber") + "        FIO: " + res.getString("FIO")
					+ "        Model: " + res.getString("Model") + "        Nalichie: " + res.getBoolean("Nalichie")
					+ "        Oplata: " + res.getBoolean("Oplata") + "\n";

		}
		tf_2.setText(s);
	
		}

	@FXML
	void truee() throws SQLException {

		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		Statement statement = co.createStatement();
		statement.close();
		java.sql.PreparedStatement myStmt = co.prepareStatement ("SELECT *   FROM ekvaizer WHERE   Oplata = '1' ");

		ResultSet res = myStmt.executeQuery();
		String s = "";
		while (res.next()) {

			s += "        Namber: " + res.getString("Namber") + "        FIO: " + res.getString("FIO")
					+ "        Model: " + res.getString("Model") + "        Nalichie: " + res.getBoolean("Nalichie")
					+ "        Oplata: " + res.getBoolean("Oplata") + "\n";
		}
		tf_2.setText(s);
	}

	@FXML
	void delete() throws SQLException, ClassNotFoundException {
		 
	 	 
	 		
	 		String nomer = qw_1.getText();
	 			 
	 		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

			Statement statement = co.createStatement();
			java.sql.PreparedStatement myStmt = co

					.prepareStatement( "DELETE FROM ekvaizer WHERE FIO=?" );
	 	 
			myStmt.setString( 1,nomer );
			myStmt.executeUpdate();
	 	  
			Connection2();
			statement.close();
		 
				   		 
			
				 }

	@FXML
	void insert() throws SQLException, ClassNotFoundException {

		 String q1 =w_1.getText();
		 String q2 =w_2.getText();
		 String q3 =w_3.getText();
		 String q4 =w_4.getText();
		 String q5 =w_5.getText();
 
	 		Connection co = DriverManager.getConnection("jdbc:sqlite::resource:application/ekvaizer.db");

		java.sql.PreparedStatement myStmt =co

				.prepareStatement("insert into ekvaizer(Namber,FIO,Model,Nalichie,Oplata)  values (?,?,?,?,?)");

		myStmt.setString(1, q1);
		myStmt.setString(2, q2);
		myStmt.setString(3, q3);
		myStmt.setString(4, q4);
		myStmt.setString(5, q5);
		myStmt.executeUpdate();

		Connection2();
	 
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
