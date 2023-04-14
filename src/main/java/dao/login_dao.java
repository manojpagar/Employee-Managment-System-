package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bin.emp_bo;
import bin.login_do;


public class login_dao {

	public static Connection connect() {
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/Project";
		String id = "root";
		String pass = "Manoj@123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int insert(login_do lb) {
		int status = 0;

		try {

			Connection con = login_dao.connect();

			String qurey = "INSERT into users values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(qurey);

			ps.setString(1, lb.getName());
			ps.setString(2, lb.getEmail());
			ps.setString(3, lb.getPassword());
			ps.setString(4, lb.getRepassword());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static boolean user_logine(String Email, String pass) {
		boolean status = false;

		try {
			Connection con = login_dao.connect();

			String queary = "select * from users where Email=? and pass=?";

			PreparedStatement ps = con.prepareStatement(queary);

			ps.setString(1, Email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int addEmployee(emp_bo eb) {

		int status = 0;

		try {

			Connection con = login_dao.connect();

			String queary = "insert into employees values(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(queary);

			ps.setString(1, eb.getId());
			ps.setString(2, eb.getName());
			ps.setString(3, eb.getEmail());
			ps.setString(4, eb.getPhone());
			ps.setString(5, eb.getDoj());
			ps.setString(6, eb.getDob());
			ps.setString(7, eb.getAdhar());

			status = ps.executeUpdate();
		} catch (Exception e) {

			System.out.println(e);

		}

		return status;

	}

	public static List fetch() {
		List<emp_bo> list = new ArrayList<emp_bo>();

		try {

			Connection con = login_dao.connect();

			PreparedStatement ps = con.prepareStatement("select * from employees");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emp_bo eb = new emp_bo();

				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));

				eb.setPhone(rs.getString(4));
				eb.setDoj(rs.getString(5));
				eb.setDob(rs.getString(6));

				eb.setAdhar(rs.getString(7));

				list.add(eb);

			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return list;
	}

	public static int delete(String id) {

		int status = 0;

		try {

			Connection con = login_dao.connect();

			String query = "delete from employees where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);

			status = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}

	public static int update(emp_bo eb) {
		int status = 0;

		try {

			Connection con = login_dao.connect();

			String query = "update employees set name=?,email=?,phone=?, Date_of_Join=?,dob=?,Adhar=? where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, eb.getName());
			ps.setString(2, eb.getEmail());
			ps.setString(3, eb.getPhone());
			ps.setString(4, eb.getDoj());
			ps.setString(5, eb.getDob());
			ps.setString(6, eb.getAdhar());
			ps.setString(7, eb.getId());

			status = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}

	public static emp_bo getElementbyId(String id) {

		emp_bo eb = new emp_bo();

		try {
			Connection con = login_dao.connect();

			String query = "select * from employees where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));

				eb.setPhone(rs.getString(4));
				eb.setDoj(rs.getString(5));
				eb.setDob(rs.getString(6));

				eb.setAdhar(rs.getString(7));
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return eb;
	}

	public static List<emp_bo> Search_employee(emp_bo bl) {

		List<emp_bo> list = new ArrayList<emp_bo>();

		try {

			Connection con = login_dao.connect();

			PreparedStatement st = con.prepareStatement("select * from employees where id =?");
			st.setString(1, bl.getId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				emp_bo e = new emp_bo();
				e.setId(rs.getString(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhone(rs.getString(4));
				e.setDoj(rs.getString(5));
				e.setDob(rs.getString(6));
				e.setAdhar(rs.getString(7));
				

				list.add(e);

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;

	}

}