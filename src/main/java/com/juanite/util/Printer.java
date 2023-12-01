package com.juanite.util;

import com.juanite.model.domain.Document;

public class Printer extends Thread {

    public Printer() {

    }
    public void printDocument(Document document) throws InterruptedException {
        AppData.getQueueDocs().remove(document);
        AppData.setPrintingDoc(document);
        this.wait(3000);
        AppData.setPrintingDoc(null);
        AppData.getCompletedDocs().add(document);
    }
}
