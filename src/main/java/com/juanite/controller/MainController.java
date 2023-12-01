package com.juanite.controller;

import com.juanite.model.domain.Document;
import com.juanite.util.AppData;
import com.juanite.util.PrintSimulator;
import com.juanite.util.Printer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

public class MainController {

    @FXML
    public Button btn_startPause;
    @FXML
    public Button btn_clear;
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
    @FXML
    public Label lbl_printingDoc;
    private final PrintSimulator printSimulator = new PrintSimulator();
    private final Printer printer = new Printer();


    public void initialize() {
        tc_queueDocument.setCellValueFactory(new PropertyValueFactory<>("docName"));
        tc_queuePriority.setCellValueFactory(new PropertyValueFactory<>("docPriorityValue"));
        tv_queue.setItems(AppData.getQueueDocs());
        tc_completedDocument.setCellValueFactory(new PropertyValueFactory<>("docName"));
        tc_completedPriority.setCellValueFactory(new PropertyValueFactory<>("docPriorityValue"));
        tv_completed.setItems(AppData.getCompletedDocs());
        tc_documentName.setCellValueFactory(new PropertyValueFactory<>("docName"));
        tc_documentContent.setCellValueFactory(new PropertyValueFactory<>("docContent"));
        tc_documentPriority.setCellValueFactory(new PropertyValueFactory<>("docPriority"));
        tc_documentNumeric.setCellValueFactory(new PropertyValueFactory<>("docPriorityValue"));
        pb_print.progressProperty().bind(printer.progressProperty().divide(100.0));
        lbl_printingDoc.textProperty().bindBidirectional(printer.printingDocumentProperty(), new StringConverter<>() {
            @Override
            public String toString(Document document) {
                return document == null ? "" : document.getDocName();
            }

            @Override
            public Document fromString(String string) {
                throw new UnsupportedOperationException("Not needed");
            }
        });
    }

    public void startPauseQueue() {
        if (!AppData.isIsRunning()) {
            AppData.setIsRunning(true);
            printer.setStopped(false);
            btn_startPause.setText("PAUSE");
            pb_print.setVisible(true);

            new Thread(printSimulator).start();
        } else {
            AppData.setIsRunning(false);
            btn_startPause.setText("START");
            pb_print.setVisible(false);
        }
    }

    public void clearQueue() {
        if(!AppData.isIsRunning()) {
            AppData.getQueueDocs().clear();
            AppData.getCompletedDocs().clear();
            AppData.getSelectedDoc().clear();
            refreshQueue();
            refreshCompleted();
            refreshSelected();
        }
    }

    public void refreshQueue() {
        Platform.runLater(() -> tv_queue.refresh());
    }

    public void refreshCompleted() {
        Platform.runLater(() -> tv_completed.refresh());
    }

    public void refreshSelected() {
        Platform.runLater(() -> tv_completed.refresh());
    }
}
