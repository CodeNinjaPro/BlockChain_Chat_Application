//Generated by 24HRS
package Model;


public class Sesstion{

	private int sesstion_id;
	private int user_first_id;
	private int user_second_id;
	private String sesstion_key;

public Sesstion(){
}

public Sesstion(int sesstion_id){
	this.sesstion_id = sesstion_id;
}
public Sesstion(int sesstion_id,int user_first_id,int user_second_id,String sesstion_key){
	this.sesstion_id = sesstion_id;
	this.user_first_id = user_first_id;
	this.user_second_id = user_second_id;
	this.sesstion_key = sesstion_key;
}

public int getSesstion_id(){
return sesstion_id;
}

public void setSesstion_id(int sesstion_id){
	this.sesstion_id = sesstion_id;
}

public int getUser_first_id(){
return user_first_id;
}

public void setUser_first_id(int user_first_id){
	this.user_first_id = user_first_id;
}

public int getUser_second_id(){
return user_second_id;
}

public void setUser_second_id(int user_second_id){
	this.user_second_id = user_second_id;
}

public String getSesstion_key(){
return sesstion_key;
}

public void setSesstion_key(String sesstion_key){
	this.sesstion_key = sesstion_key;
}

}