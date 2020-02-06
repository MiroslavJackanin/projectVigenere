package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {
    private String path;

    public Files(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public String getFileContent(String path){
        StringBuilder data = new StringBuilder();
        try{
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                data.append("\n").append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
