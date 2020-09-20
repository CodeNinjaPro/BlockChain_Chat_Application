/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlockChain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Roshan Withanage
 */
public class NoobChain {

//    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
//
//    public static void main(String[] args) {
//
//        Block genesisBlock = new Block("dddd", "", 1, 2);
//        System.out.println("Hash for block 1 : " + genesisBlock.hash);
//
//        Block secondBlock = new Block("Yo im the second block", genesisBlock.hash, 2, 3);
//        System.out.println("Hash for block 2 : " + secondBlock.hash);
//
//        Block thirdBlock = new Block("Hey im the third block", secondBlock.hash, 2, 5);
//        System.out.println("Hash for block 3 : " + thirdBlock.hash);
//
//    }
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 1;

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:

        blockchain.add(new Block("dddd", "0", 1, 2));
        System.out.println("Trying to Mine block 1... ");
//        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash, 2, 3));
        System.out.println("Trying to Mine block 2... ");
//        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash, 2, 3));
        System.out.println("Trying to Mine block 3... ");
//        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}
