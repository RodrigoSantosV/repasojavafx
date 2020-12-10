package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    @FXML
    Button boton1;
    @FXML
    Button boton2;
    @FXML
    Button boton3;
    @FXML
    Button boton4;
    @FXML
    Button boton5;

    @FXML
    public void initialize(){

        ArrayList<Button> lista= new ArrayList<>();
        lista.add(boton1);
        lista.add(boton2);
        lista.add(boton3);
        lista.add(boton4);
        lista.add(boton5);
        Collections.shuffle(lista);
        for (int i =0;i<lista.size();i++){
            lista.get(i).setText(""+(i+1));

        }

    }

    private int numeroEsperado=1;
    @FXML
    private void b1Clicked (MouseEvent event){

        Button b = (Button)event.getSource();
        if(Integer.parseInt(b.getText())==numeroEsperado){

            numeroEsperado++;
            if(numeroEsperado>5){
                System.out.println("Abriendo ventana");
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Stage primaryStage=new Stage();
                    primaryStage.setTitle("Hello World");
                    primaryStage.setScene(new Scene(root, 300, 275));
                    primaryStage.show();
                }catch (IOException E) {
                    E.printStackTrace();
                }

            }

        }else{
            System.out.println("Has fallado, inutil");
            numeroEsperado=1;
        }
    }



}
