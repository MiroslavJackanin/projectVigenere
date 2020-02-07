package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {
    private String path;
    private String parent;

    public Files(String path, String parent) {
        this.path = path;
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }
    public String getParent() {
        return parent;
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
