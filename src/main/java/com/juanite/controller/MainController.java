package com.juanite.controller;

import com.juanite.model.domain.Document;
import com.juanite.util.AppData;
import com.juanite.util.PrintSimulator;
import com.juanite.util.Printer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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
    @FXML
    public ProgressBar pb_print;
    private PrintSimulator printSimulator = new PrintSimulator();
    private Printer printer = new Printer();

    void initialize() {

    }

    public void startPauseQueue() {
        if(!AppData.isIsRunning()) {
            AppData.setIsRunning(true);
            printSimulator.run();
        } else {
            AppData.setIsRunning(false);
        }
    }

    public void stopQueue() {

    }

    public void refreshQueue() {
        tv_queue.setItems(AppData.getQueueDocs());
        tv_queue.refresh();
    }

    public void refreshCompleted() {
        tv_completed.setItems(AppData.getCompletedDocs());
        tv_completed.refresh();
    }

    public void refreshSelected() {
        tv_document.setItems(AppData.getSelectedDoc());
        tv_document.refresh();
    }
}
