//Generated by 24HRS
package Model;


public class User{

	private int user_id;
	private String user_fullname;
	private String usertype;
	private String email;
	private String username;
	private String password;
	private String public_key;
	private String private_key;

public User(){
}

public User(int user_id){
	this.user_id = user_id;
}
public User(int user_id,String user_fullname,String usertype,String email,String username,String password,String public_key,String private_key){
	this.user_id = user_id;
	this.user_fullname = user_fullname;
	this.usertype = usertype;
	this.email = email;
	this.username = username;
	this.password = password;
	this.public_key = public_key;
	this.private_key = private_key;
}

public int getUser_id(){
return user_id;
}

public void setUser_id(int user_id){
	this.user_id = user_id;
}

public String getUser_fullname(){
return user_fullname;
}

public void setUser_fullname(String user_fullname){
	this.user_fullname = user_fullname;
}

public String getUsertype(){
return usertype;
}

public void setUsertype(String usertype){
	this.usertype = usertype;
}

public String getEmail(){
return email;
}

public void setEmail(String email){
	this.email = email;
}

public String getUsername(){
return username;
}

public void setUsername(String username){
	this.username = username;
}

public String getPassword(){
return password;
}

public void setPassword(String password){
	this.password = password;
}

public String getPublic_key(){
return public_key;
}

public void setPublic_key(String public_key){
	this.public_key = public_key;
}

public String getPrivate_key(){
return private_key;
}

public void setPrivate_key(String private_key){
	this.private_key = private_key;
}

}