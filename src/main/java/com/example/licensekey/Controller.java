package com.example.licensekey;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Key> table;
    @FXML
    private TableColumn<Key, Integer> id;
    @FXML
    private TableColumn<Key,String> serialNumber;
    @FXML
    private TableColumn<Key,String> licenseKey;
    @FXML
    Button export;
    @FXML
    Label confirmation;


    List<Key> list = new ArrayList<>();
    ObservableList<Key> listArray;

    // parsing a CSV file into Scanner class constructor
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(new PropertyValueFactory<Key,Integer>("id"));
        serialNumber.setCellValueFactory(new PropertyValueFactory<Key,String>("serialNumber"));
       licenseKey.setCellValueFactory(new PropertyValueFactory<Key,String>("licenseKey"));
//       readCSV();
        listArray= FXCollections.observableArrayList(list);
        table.setItems(listArray);
    }
    public void assignValues(int id, String sn, String licenseKey)
    {
//       list.add(new Key(id,sn,licenseKey)) ;
    }


    public void onImportButtonClicked(ActionEvent event) throws IOException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(table.getScene().getWindow());
        readCSV(file);
        listArray= FXCollections.observableArrayList(list);
        table.setItems(listArray);
        confirmation.setText("Imported");
    }
    public void onExportButtonClicked(ActionEvent event) throws IOException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files","*.*"));
        File selectedFile = fileChooser.showSaveDialog(table.getScene().getWindow());
        if(selectedFile !=null)
        {
            writeCSV(selectedFile);
        }
        confirmation.setText("Exported");

    }
    public void writeCSV(File selectecFile)
    {

        try{
            FileWriter outputFile = new FileWriter(selectecFile);
            CSVWriter writer = new CSVWriter(outputFile);

            List<String[]> data = new ArrayList<String[]>();
            for(int i =0;i<table.getItems().size();i++)
            {
                String rowValue = table.getItems().get(i).getId() + "," + table.getItems().get(i).getSerialNumber() +","+table.getItems().get(i).getLicenseKey();
                String[] rowData = rowValue.split(",");
                data.add(rowData);
            }
            writer.writeAll(data);
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCSV(File file) {
        CSVReader reader = null;

        try {
//            reader = new CSVReader(new FileReader("E:\\Book1.csv"));
            reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                list.add(new Key(Integer.parseInt(nextLine[0]),nextLine[1],coding(nextLine[1])));
//                list =FXCollections.observableArrayList(new Key(Integer.parseInt(nextLine[0]),nextLine[1],coding(nextLine[2])));
//                    assignValues(Integer.parseInt(nextLine[0]),nextLine[1],coding(nextLine[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Handle the exception if needed
                }
            }
        }
    }

    public String coding(String input)
    {
        return input.toLowerCase();
    }





}