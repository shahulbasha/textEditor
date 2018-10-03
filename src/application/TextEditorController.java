package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.jfoenix.controls.JFXTextArea;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TextEditorController {
	
	

    @FXML
    private JFXTextArea textarea;

    @FXML
    void onAbout(ActionEvent event) {
    	textarea.setText("This is a simple Text Editor version 1.0 by Shahul");

    }

    @FXML
    void onExit(ActionEvent event) {

    	Platform.exit();
    }

    @FXML
    void onOpen(ActionEvent event) {

    	Stage stage=new Stage();
    	FileChooser fileChooser =new FileChooser();
    	fileChooser.setTitle("Open File");
    	fileChooser.setInitialDirectory(new File("C:\\Users\\basha\\Desktop\\Java"));
    	
    	File file=fileChooser.showOpenDialog(stage);
    	
    	
    	try {
			FileReader fileReader=new FileReader(file.getAbsolutePath().toString());
			BufferedReader br=new BufferedReader(fileReader);
			StringBuilder sb=new StringBuilder();
			String myText="";
			while((myText=br.readLine())!=null) {
				sb.append(myText+"\n");
			}
			
			textarea.setText(sb.toString());
		} catch (Exception f) {
			// TODO Auto-generated catch block
			System.out.println(f.getMessage());
		}
    }

    @FXML
    void onSave(ActionEvent event) {
    	Stage stage=new Stage();
    	FileChooser fileChooser=new FileChooser();
    	fileChooser.setTitle("Save File");
    	fileChooser.setInitialDirectory(new File("C:\\Users\\basha\\Desktop\\Java"));
    	File savedFile = fileChooser.showSaveDialog(stage);
    	
    	try {
			FileWriter writer=new FileWriter(savedFile.getAbsolutePath().toString());
			writer.write(textarea.getText());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    }
    
    @FXML
    void onNew(ActionEvent event) {
    	textarea.clear();
    }
}
