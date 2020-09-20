/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Roshan Withanage
 */
public class RSA {

    private static final String PUCLIC_KEY_FILE = "Public.key";
    private static final String PRIVATE_KEY_FILE = "Private.key";

    private RSA() {
    }

    private static final RSA obj = new RSA();

    public static RSA getInstance() {
        return obj;
    }

    public void genarateKEYS(String value) {

        
    }


}
