package com.juanite.util;

import com.juanite.model.domain.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AppData {
    private static boolean isRunning = false;
    private static Document printingDoc;
    private static ObservableList<Document> queueDocs = FXCollections.observableArrayList();
    private static ObservableList<Document> completedDocs = FXCollections.observableArrayList();
    private static ObservableList<Document> selectedDoc = FXCollections.observableArrayList();

    public static synchronized boolean isIsRunning() {
        return isRunning;
    }

    public static synchronized void setIsRunning(boolean isRunning) {
        AppData.isRunning = isRunning;
    }

    public static synchronized Document getPrintingDoc() {
        return printingDoc;
    }

    public static synchronized void setPrintingDoc(Document printingDoc) {
        AppData.printingDoc = printingDoc;
    }

    public static synchronized ObservableList<Document> getQueueDocs() {
        return queueDocs;
    }

    public static synchronized void setQueueDocs(ObservableList<Document> queueDocs) {
        AppData.queueDocs = queueDocs;
    }

    public static synchronized ObservableList<Document> getCompletedDocs() {
        return completedDocs;
    }

    public static synchronized void setCompletedDocs(ObservableList<Document> completedDocs) {
        AppData.completedDocs = completedDocs;
    }

    public static synchronized ObservableList<Document> getSelectedDoc() {
        return selectedDoc;
    }

    public static synchronized void setSelectedDoc(ObservableList<Document> selectedDoc) {
        AppData.selectedDoc = selectedDoc;
    }
}
