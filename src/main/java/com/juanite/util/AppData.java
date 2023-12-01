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

    public static boolean isIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean isRunning) {
        AppData.isRunning = isRunning;
    }

    public static Document getPrintingDoc() {
        return printingDoc;
    }

    public static void setPrintingDoc(Document printingDoc) {
        AppData.printingDoc = printingDoc;
    }

    public static ObservableList<Document> getQueueDocs() {
        return queueDocs;
    }

    public static void setQueueDocs(ObservableList<Document> queueDocs) {
        AppData.queueDocs = queueDocs;
    }

    public static ObservableList<Document> getCompletedDocs() {
        return completedDocs;
    }

    public static void setCompletedDocs(ObservableList<Document> completedDocs) {
        AppData.completedDocs = completedDocs;
    }

    public static ObservableList<Document> getSelectedDoc() {
        return selectedDoc;
    }

    public static void setSelectedDoc(ObservableList<Document> selectedDoc) {
        AppData.selectedDoc = selectedDoc;
    }
}
