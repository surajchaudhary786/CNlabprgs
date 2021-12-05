package CN_lab;

import java.util.*;

public class crc {
    public static void main(String[] args) {
        int[] msg;
        int[] app;
        int[] gen;
        int[] rcv;
        int mslen, genlen;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the message lenghth: ");
        mslen = sc.nextInt();
        msg = new int[mslen];
        System.out.print("enter the message bits");
        for (int i = 0; i < mslen; i++) {
            msg[i] = sc.nextInt();
        }
        System.out.print("enter the generator bit lenghth");
        genlen = sc.nextInt();
        gen = new int[genlen];
        System.out.print("enter the generator bits");
        for (int i = 0; i < genlen; i++) {
            gen[i] = sc.nextInt();
        }
        app = new int[mslen + genlen - 1];
        for (int i = 0; i < mslen; i++) {
            app[i] = msg[i];
        }
        System.out.println("appeneded message is : ");
        for (int i = 0; i < mslen + genlen - 1; i++) {
            System.out.print(app[i]);
        }
        System.out.println("");
        // calculation of crc

        for (int i = 0; i < mslen; i++) {
            if (app[i] == 1) {
                for (int j = 0; j < genlen; j++) {
                    app[i + j] ^= gen[j];
                }
            }
        }
        // dispaly of contract

        for (int i = 0; i < mslen; i++) {
            app[i] = msg[i];
        }
        System.out.println("transmitted crc checksum is: ");
        for (int i = 0; i < mslen + genlen - 1; i++) {
            System.out.print(app[i]);
        }
        System.out.println("enter the received message(checksum)");
        rcv = new int[mslen + genlen - 1];
        for (int i = 0; i < mslen + genlen - 1; i++) {
            rcv[i] = sc.nextInt();
        }
        // validation
        for (int i = 0; i < mslen; i++) {
            if (rcv[i] == 1) {
                for (int j = 0; j < genlen; j++) {
                    rcv[i + j] ^= gen[j];
                }
            }
        }
        int i;
        for (i = 0; i < mslen + genlen - 1; i++) {
            if (rcv[i] != 0) {
                break;
            }
        }
        if (i == mslen + genlen - 1) {
            System.out.println("got correct data");
        } else {
            System.out.println("got fault");
        }
        sc.close();

    }

}
