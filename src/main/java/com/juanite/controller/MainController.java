package com.juanite.controller;

import com.juanite.model.domain.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

    @FXML
    public Button btn_startPause;
    @FXML
    public Button btn_stop;
    @FXML
    public TableView<Document> tv_queue;
    @FXML
    public TableColumn<Document,String> tc_queueDocument;
    @FXML
    public TableColumn<Document,Integer> tc_queuePriority;
    @FXML
    public TableView<Document> tv_completed;
    @FXML
    public TableColumn<Document,String> tc_completedDocument;
    @FXML
    public TableColumn<Document,Integer> tc_completedPriority;
    @FXML
    public TableView<Document> tv_document;
    @FXML
    public TableColumn<Document,String> tc_documentName;
    @FXML
    public TableColumn<Document,String> tc_documentContent;
    @FXML
    public TableColumn<Document,String> tc_documentPriority;
    @FXML
    public TableColumn<Document,Integer> tc_documentNumeric;

    private ObservableList<Document> queueDocs = FXCollections.observableArrayList();
    private ObservableList<Document> completedDocs = FXCollections.observableArrayList();
    private ObservableList<Document> focusedDoc = FXCollections.observableArrayList();

    void initialize() {

    }
}
