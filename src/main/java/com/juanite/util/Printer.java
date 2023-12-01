package com.juanite.util;

import com.juanite.model.domain.Document;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Printer extends Thread {

    private List<Document> docs;
    private boolean isStopped;
    private DoubleProperty progress;
    private ObjectProperty<Document> printingDocument;

    public Printer() {
        this.docs = new ArrayList<>();
        this.isStopped = true;
        this.progress = new SimpleDoubleProperty(0.0);
        this.printingDocument = new SimpleObjectProperty<>(null);
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    public double getProgress() {
        return progress.get();
    }

    public DoubleProperty progressProperty() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress.set(progress);
    }

    public Document getPrintingDocument() {
        return printingDocument.get();
    }

    public ObjectProperty<Document> printingDocumentProperty() {
        return printingDocument;
    }

    public void setPrintingDocument(Document printingDocument) {
        this.printingDocument.set(printingDocument);
    }

    public void start() {
        super.start();
        AppData.getQueueDocs().addListener((ListChangeListener<Document>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    docs.addAll(change.getAddedSubList());
                    printDocuments();
                }
            }
        });
    }

    private void printDocuments() {
        Iterator<Document> iterator = docs.iterator();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            iterator.remove();
            AppData.setPrintingDoc(document);
            setPrintingDocument(document); // Notify the document being printed

            // Simulate printing
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);  // Adjust this value based on your desired progress speed
                    int finalI = i;
                    Platform.runLater(() -> {
                        progress.set((finalI + 1) * 10.0);
                        setPrintingDocument(document);
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            AppData.setPrintingDoc(null);
            AppData.getCompletedDocs().add(document);
            setPrintingDocument(null); // Notify that no document is being printed
        }
    }


}
