package com.juanite.util;

import com.juanite.model.domain.Document;
import com.juanite.model.domain.Priority;

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
                this.wait(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            double docProc = 0 + 100 * Math.random();
            if(docProc >= 70) {
                Document doc = new Document(
                        "Document" + nameModifier,
                        "This is the content from Document" + nameModifier,
                        Priority.LOW
                );
                AppData.getQueueDocs().add(doc);
                nameModifier++;
            }
            docProc = 0 + 100 * Math.random();
            if(docProc >= 50) {
                Document doc = new Document(
                        "Document" + nameModifier,
                        "This is the content from Document" + nameModifier,
                        Priority.MEDIUM
                );
                AppData.getQueueDocs().add(doc);
                nameModifier++;
            }
            docProc = 0 + 100 * Math.random();
            if(docProc >= 80) {
                Document doc = new Document(
                        "Document" + nameModifier,
                        "This is the content from Document" + nameModifier,
                        Priority.HIGH
                );
                AppData.getQueueDocs().add(doc);
                nameModifier++;
            }
        }
    }
}
