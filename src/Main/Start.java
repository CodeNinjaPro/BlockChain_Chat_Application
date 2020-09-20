/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import View.Chat_Application;
import View.Home;
import View.Login;


/**
 *
 * @author Roshan Withanage
 */
public class Start {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, Exception {
        
        
//        Pinpon obj = Pinpon.getInstance();
//        
//        System.out.println(obj.getOTP(Instant.now().getEpochSecond()));
        

//            Home obj = new Home();
            Login obj = new Login();
            
            obj.setVisible(true);
        

//
//        LFSR obj = LFSR.getInstance();
//        System.out.println(obj.Convert("14569875"));
    }
    
}
