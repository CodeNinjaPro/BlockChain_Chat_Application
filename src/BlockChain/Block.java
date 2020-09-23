/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlockChain;

import java.time.Instant;

/**
 *
 * @author Roshan Withanage
 */
public class Block {

    public String hash;
    public String previousHash;
    private int sender_id;
    private int recever_id;
    private String data; //our data will be a simple message.
    private long timeStamp; //as number of milliseconds since 1/1/1970.
    private int nonce;

    //Block Constructor.
    public Block(String data, String previousHash, int sender_id, int recever_id) {
        this.data = data;
        this.previousHash = previousHash;
        this.sender_id = sender_id;
        this.recever_id = recever_id;
        this.timeStamp = Instant.now().getEpochSecond();
        this.hash = calculateHash(); //Making sure we do this after we set the other values.
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash
                + Long.toString(timeStamp)
                + data
        );
        return calculatedhash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    public String getHash() {
        return hash;
    }
    
    
}
