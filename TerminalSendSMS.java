package com.app.sms.sending.sms;

import com.app.dao.DaoImpl;
import com.app.sms.reader.impl.ClientReadingSms;
import com.app.sms.reader.impl.ReadSmsAdministrator;
import com.app.sms.reader.impl.SimpleSmsReader;
import com.app.text.decoder.impl.SimpleDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalSendSMS  implements SendSms {

/*

    public static void smsSend5(String sms, String asd, String s1) {

        Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[]{sms,asd,s1});
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;

        while (true) {
            try {
                if (!((line = input.readLine()) != null)) break;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(line);
        }

        int exitVal = 0;
        try {
            exitVal = p.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Exited with error code " + exitVal);

    }

 */





    public static void sendSMS(){


        System.out.println("nnnn|nnnn? nnnn dd.mm.yy|nnnn on/off");

    }


    public static void send1SMS(){

        System.out.println("Ошибка Данный номер не найден");
    } public static void send2SMS(){

        System.out.println("Машоил");
    }





}

    /*
 public static void smsSend() {

      Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[]{"bash", "-c", "sendsms 79827956841 'nnnn|nnnn? nnnn dd.mm.yy|nnnn on/off' "});
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;

        while (true) {
            try {
                if (!((line = input.readLine()) != null)) break;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(line);
        }

        int exitVal = 0;
        try {
            exitVal = p.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Exited with error code " + exitVal);


    }

     */


















