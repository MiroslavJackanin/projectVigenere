package sample;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Cipher {

    public String encrypt(String code, String path){
        if (code.equals("")){
            return "Wrong input";
        }
        StringBuilder data = new StringBuilder();
        String key = code.toLowerCase();
        int keyCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            int c;
            while ((c = reader.read()) != -1) {
                if (key.charAt(keyCount) < 97){
                    return "Wrong input";
                }
                if ((char) c >= 65 && (char) c <= 90) {
                    char ch = (char) (c + ((key.charAt(keyCount)) - 97));
                    if ((int) ch > 90) {
                        ch -= 26;
                    }
                    data.append(ch);
                }else if ((char) c >= 97 && (char) c <= 122){
                    char ch = (char) (c + ((key.charAt(keyCount)) - 97));
                    if ((int) ch > 122) {
                        ch -= 26;
                    }
                    data.append(ch);
                }else
                    data.append((char) c);

                keyCount++;
                if (keyCount >= key.length()){
                    keyCount = 0;
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\MIRO\\Desktop\\encrypted_data.txt"));
            writer.write(data.toString());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return data.toString();
    }

    public String decrypt(String code, String path){
        if (code.equals("")){
            return "Wrong input";
        }
        StringBuilder data = new StringBuilder();
        String key = code.toLowerCase();
        int keyCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            int c;
            while ((c = reader.read()) != -1) {
                if (key.charAt(keyCount) < 97){
                    return "Wrong input";
                }
                if ((char) c >= 65 && (char) c <= 90) {
                    char ch = (char) (c - ((key.charAt(keyCount)) - 97));
                    if ((int) ch < 65) {
                        ch += 26;
                    }
                    data.append(ch);
                }else if ((char) c >= 97 && (char) c <= 122){
                    char ch = (char) (c - ((key.charAt(keyCount)) - 97));
                    if ((int) ch < 97) {
                        ch += 26;
                    }
                    data.append(ch);
                }else
                    data.append((char) c);

                keyCount++;
                if (keyCount >= key.length()){
                    keyCount = 0;
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\MIRO\\Desktop\\decrypted_data.txt"));
            writer.write(data.toString());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return data.toString();
    }
}
