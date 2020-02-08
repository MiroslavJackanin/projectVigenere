package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.swing.JFileChooser;
import java.io.File;

public class Controller {
    public Pane mainPane;
    public Label filePath;
    public Label fileContent;
    public TextField keyForm;

    public void initialize(){
        filePath.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        fileContent.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void openFileChooser(){
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\MIRO\\Desktop");
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Files files = new Files(selectedFile.getAbsolutePath(), selectedFile.getParent());

            filePath.setText(selectedFile.getAbsolutePath());
            fileContent.setText(files.getFileContent(selectedFile.getAbsolutePath()));
        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }

    public void encrypt(){
        Cipher cipher = new Cipher();
        fileContent.setText(cipher.encrypt(keyForm.getText(), filePath.getText()));
    }

    public void decrypt(){
        Cipher cipher = new Cipher();
        fileContent.setText(cipher.decrypt(keyForm.getText(), filePath.getText()));
    }
}
