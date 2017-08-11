package com.zuoqiang.ConcreencyCollections.t4;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed {
    private Date startDate;

    public Event(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {   //返回当前日期与实际日期的间隔
        Date now = new Date();
        long dff = this.startDate.getTime() - now.getTime();
        return unit.convert(dff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {    //比较延迟值的大小
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
