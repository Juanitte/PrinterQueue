package com.juanite.util;

import com.juanite.model.domain.Document;
import com.juanite.model.domain.Priority;
import javafx.application.Platform;

public class PrintSimulator implements Runnable {

    private int nameModifier;

    public PrintSimulator() {
        this.nameModifier = 1;
    }

    public int getNameModifier() {
        return nameModifier;
    }

    public void setNameModifier(int nameModifier) {
        this.nameModifier = nameModifier;
    }

    @Override
    public void run() {
        while(AppData.isIsRunning()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            double docProc = 0 + 100 * Math.random();
            if(docProc >= 80) {
                Document doc = new Document(
                        "Document" + nameModifier,
                        "This is the content from Document" + nameModifier,
                        Priority.LOW
                );
                Platform.runLater(() -> AppData.getQueueDocs().add(doc));
                nameModifier++;
            }
            docProc = 0 + 100 * Math.random();
            if(docProc >= 75) {
                Document doc = new Document(
                        "Document" + nameModifier,
                        "This is the content from Document" + nameModifier,
                        Priority.MEDIUM
                );
                Platform.runLater(() -> AppData.getQueueDocs().add(doc));
                nameModifier++;
            }
            docProc = 0 + 100 * Math.random();
            if(docProc >= 80) {
                Document doc = new Document(
                        "Document" + nameModifier,
                        "This is the content from Document" + nameModifier,
                        Priority.HIGH
                );
                Platform.runLater(() -> AppData.getQueueDocs().add(doc));
                nameModifier++;
            }
        }
    }
}
