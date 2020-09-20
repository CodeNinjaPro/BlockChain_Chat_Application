/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
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
public class RSA_test {

    private static final String PUCLIC_KEY_FILE = "Public.key";
    private static final String PRIVATE_KEY_FILE = "Private.key";

    public static void main(String[] args) {

        try {
            System.out.println("-----------------GENARATE PUBLIC and PRIVATE KEY-----------------------");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);//1024 used for normal securities
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            System.out.println("-----------------PULLING OUT PARAMETERS WHICH MAKES KEYPAIR------------------\n");
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec rsaPublicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            RSAPrivateKeySpec rsaPrivateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

            System.out.println("\n-------------------SAVING PUBLIC KEY AND PRIVATE KEY TO FILES-----------------\n");
            RSA_test rsaObj = new RSA_test();
            rsaObj.saveKeys(PUCLIC_KEY_FILE, rsaPublicKeySpec.getModulus(), rsaPublicKeySpec.getPublicExponent());
            rsaObj.saveKeys(PRIVATE_KEY_FILE, rsaPrivateKeySpec.getModulus(), rsaPrivateKeySpec.getPrivateExponent());

            //Encrypt Data using Public Key
            byte[] encryptedData = rsaObj.encryptData("Data to encrypt");

            //Descypt Data using Private Key
            rsaObj.decryptData(encryptedData);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void saveKeys(String fileName, BigInteger mod, BigInteger exp) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            System.out.println("Generating " + fileName + "...");
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(new BufferedOutputStream(fos));
            oos.writeObject(mod);
            oos.writeObject(exp);
            System.out.println(fileName + " Generated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
                if (fos != null) {
                    fos.close();
                }
            }
        }

    }

    private byte[] encryptData(String data) throws IOException {
        System.out.println("\n---------------------------ENCRYPTION STARTED---------------------------");
        System.out.println("Data Befor encryption : " + data);
        byte[] dataToEncypt = data.getBytes();
        byte[] encrytedData = null;

        try {
            PublicKey pubKey = readPublicKeyFromFile(this.PUCLIC_KEY_FILE);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            encrytedData = cipher.doFinal(dataToEncypt);
            System.out.println("Encrypted Data : " + encrytedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------ENCRYPTION COMPLETED----------------------------");
        return encrytedData;
    }

    private void decryptData(byte[] data) {
        System.out.println("\n---------------------DECRYPTION STARTED--------------------------");
        byte[] descrytedData = null;
        try {
            PrivateKey privateKey = readPrivateKeyFromFile(this.PRIVATE_KEY_FILE);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            descrytedData = cipher.doFinal(data);
            System.out.println("Decrypted Data : " + new String(descrytedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------------DECRYPTION COMPLETED-------------------------");
    }

    private PublicKey readPublicKeyFromFile(String fileName) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(new File(fileName));
            ois = new ObjectInputStream(fis);
            BigInteger modulus = (BigInteger) ois.readObject();
            BigInteger exponent = (BigInteger) ois.readObject();

            RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PublicKey publicKey = fact.generatePublic(rsaPublicKeySpec);
            return publicKey;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
                if (fis != null) {
                    fis.close();
                }
            }
        }
        return null;

    }

    private PrivateKey readPrivateKeyFromFile(String fileName) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(new File(fileName));
            ois = new ObjectInputStream(fis);
            BigInteger modulus = (BigInteger) ois.readObject();
            BigInteger exponent = (BigInteger) ois.readObject();

            RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = fact.generatePrivate(rsaPrivateKeySpec);
            return privateKey;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
                if (fis != null) {
                    fis.close();
                }
            }
        }
        return null;
    }

}
