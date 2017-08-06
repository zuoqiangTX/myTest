package com.zuoqiang.ThreadSychorized.t6;

public class Producer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public Producer(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    public void run() {
        buffer.setPendinglines(true);
        while (fileMock.hasMoreLines()){
            String line=fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendinglines(false);

    }
}
