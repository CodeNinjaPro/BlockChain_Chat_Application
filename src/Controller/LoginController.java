/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBaseConnector.Connector;
import Model.LoginModel;
import java.sql.ResultSet;
import sun.management.ConnectorAddressLink;

/**
 *
 * @author Roshan Withanage
 */
public class LoginController {

    Connector con = Connector.getInstance();

    private LoginController() {
    }

    private static final LoginController obj = new LoginController();

    public static LoginController getInstance() {
        return obj;
    }

    public boolean Login(String username) throws Exception {

        con.getConnection();
        ResultSet rs = con.srh("SELECT * FROM user WHERE username = '"+username+"'");
        if (rs.next()) {
            LoginModel lm = LoginModel.getInstance();
            lm.setUser_id(rs.getInt(1));
            lm.setUser_fullname(rs.getString(2));
            lm.setUsertype(rs.getString(3));
            lm.setEmail(rs.getString(4));
            lm.setUsername(rs.getString(5));
            lm.setPassword(rs.getString(6));
            lm.setPublic_key(rs.getString(7));
            lm.setPrivate_key(rs.getString(8));

            return true;
        } else {
            return false;
        }

    }

}
