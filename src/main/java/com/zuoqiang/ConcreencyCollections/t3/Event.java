package com.zuoqiang.ConcreencyCollections.t3;

public class Event implements Comparable<Event> {
    private int threadNum;
    private int priority;

    public Event(int threadNum, int priority) {
        this.threadNum = threadNum;
        this.priority = priority;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Event o) {   //与大多compareTo方法实现相反
        if (this.priority > o.getPriority()) {
            return -1;
        } else if (this.priority < o.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    }
}
