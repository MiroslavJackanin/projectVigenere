package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.swing.JFileChooser;
import java.io.File;

public class Controller {
    public Pane mainPane;
    public Label filePath;
    public Label fileContent;

    public void openFileChooser(){
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\MIRO\\Desktop");
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Files files = new Files(selectedFile.getAbsolutePath());

            filePath.setText(selectedFile.getAbsolutePath());
            fileContent.setText(files.getFileContent(selectedFile.getAbsolutePath()));
        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }
}
