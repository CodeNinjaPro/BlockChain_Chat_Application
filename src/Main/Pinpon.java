/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Roshan Withanage
 */
public class Pinpon {

    private Pinpon() {
    }

    private static Pinpon obj = new Pinpon();

    public static Pinpon getInstance() {
        return obj;
    }

    public String getOTP(long timestamp) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        //timestamp converted to hexa value
        String hex = Long.toHexString(timestamp);

        //get last bit
        String LastBitHex = hex.substring(hex.length() - 1);
        //get last 4bit
        String Last4BitHex = hex.substring(hex.length() - 8);

        //convert last bit to decimal
        int LastBitDecimal = Integer.parseInt(LastBitHex, 16);

        //convert last 4 bit to binary
        String Last4BitBinary = new BigInteger(Last4BitHex, 16).toString(2);

        String input = Last4BitBinary.substring(LastBitDecimal, LastBitDecimal + 8);

        //PRNG value (8bit)
        Random ranGen = new Random();
        String key = Integer.toBinaryString(ranGen.nextInt(999));

        while (key.length() < 8) {
            key += "0";
        }
        key = key.substring(0, 8);

        //LFSR to input and key
//        input = LFSR.getInstance().Convert(input);
//        key = LFSR.getInstance().Convert(key);
        //XOR input and key
        String xor = "";
        for (int i = 0; i < 8; i++) {
            if (input.charAt(i) == key.charAt(i)) {
                xor += "0";
            } else {
                xor += "1";
            }
        }

//        System.out.println(input);
//        System.out.println(key);
//        System.out.println(xor);
        int xorDecimal = Integer.parseInt(xor, 2);

        //left rotation xor and + input
        String first_rotated_value = input.substring(0, 2) + toBinary((xorDecimal << 1) | (xorDecimal >> (32 - 1)));
        String second_rotated_value = input.substring(2, 4) + toBinary((xorDecimal << 2) | (xorDecimal >> (32 - 2)));
        String third_rotated_value = input.substring(4, 6) + toBinary((xorDecimal << 3) | (xorDecimal >> (32 - 3)));
        String forth_rotated_value = input.substring(6, 8) + toBinary((xorDecimal << 4) | (xorDecimal >> (32 - 4)));

        String all = first_rotated_value + second_rotated_value + third_rotated_value + forth_rotated_value;

//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
//        buffer.putLong(Long.parseLong(all, 2));
//
//        int offset = 10;
//        int length = 24;
//        byte[] cipherText = cipher.doFinal(buffer.putLong(Long.parseLong(all, 2)).array(), offset, length);

        return Long.parseLong(all, 2)+"";
    }

    public String toBinary(int n) {
        int count = 0, a;
        String x = "";
        while (n > 0) {
            a = n % 2;
            if (a == 1) {
                count++;
            }
            x = a + "" + x;
            n = n / 2;
        }
        return x;
    }
}
