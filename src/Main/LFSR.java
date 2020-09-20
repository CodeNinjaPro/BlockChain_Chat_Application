/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Roshan Withanage
 */
public class LFSR {

    String output = "";

    private LFSR() {
    }

    private static final LFSR obj = new LFSR();

    public static LFSR getInstance() {
        return obj;
    }

    public String Convert(String input) {
        output = "";
        // initial fill
        boolean[] a = {
            false, true, false, false, false,
            false, true, false, true, true, false
        };
        int trials = input.length();    // number of steps
        int n = a.length;                          // length of register
        int TAP = 8;                               // tap position

        // Simulate operation of shift register.
        for (int t = 0; t < trials; t++) {

            // Simulate one shift-register step.
            boolean next = (a[n - 1] ^ a[TAP]);  // Compute next bit.

            for (int i = n - 1; i > 0; i--) {
                a[i] = a[i - 1];                  // Shift one position.
            }
            a[0] = next;                       // Put next bit on right end.

            if (next) {
                output += "1";
            } else {
                output += "0";
            }
        }

        return output;
    }
}
