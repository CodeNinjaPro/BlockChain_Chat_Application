//Generated by 24HRS
package Controller;


import Model.Sesstion;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SesstionController{

	Connector con = Connector.getInstance();

	private SesstionController(){
	}

	private static final SesstionController obj = new SesstionController();

	public static SesstionController getInstance(){
		return obj;
	}

	public void Save(Sesstion data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO sesstion(user_first_id,user_second_id,sesstion_key) values ('" + data.getUser_first_id()+ "','" + data.getUser_second_id()+ "','" + data.getSesstion_key()+ "') " );
	}

	public void Update(Sesstion data) throws Exception {
		con.getConnection();
		con.aud("UPDATE sesstion SET user_first_id  = '" + data.getUser_first_id()+ "',user_second_id  = '" + data.getUser_second_id()+ "',sesstion_key  = '" + data.getSesstion_key()+ "' WHERE sesstion_id = '" + data.getSesstion_id()+ "'");
	}

	public void Delete(Sesstion data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM sesstion WHERE sesstion_id = '" + data.getSesstion_id()+ "'");
	}

	public List<Sesstion> SearchAll() throws Exception {
		List<Sesstion> objList = new ArrayList<Sesstion>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM sesstion");
		while(rset.next()){
			Sesstion obj = new Sesstion();
			obj.setSesstion_id(rset.getInt(1));
			obj.setUser_first_id(rset.getInt(2));
			obj.setUser_second_id(rset.getInt(3));
			obj.setSesstion_key(rset.getString(4));
			objList.add(obj);
		}

	return objList;
	}

	public List<Sesstion> Search(Sesstion data) throws Exception {
		List<Sesstion> objList = new ArrayList<Sesstion>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM sesstion WHERE sesstion_id = '" + data.getSesstion_id()+ "'");
		while(rset.next()){
			Sesstion obj = new Sesstion();
			obj.setSesstion_id(rset.getInt(1));
			obj.setUser_first_id(rset.getInt(2));
			obj.setUser_second_id(rset.getInt(3));
			obj.setSesstion_key(rset.getString(4));
			objList.add(obj);
		}

	return objList;
	}

}