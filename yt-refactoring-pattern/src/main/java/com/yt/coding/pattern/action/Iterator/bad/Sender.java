package com.yt.coding.pattern.action.Iterator.bad;

/**
 * @author SUN
 * @create 2019-04-29 下午3:10
 * @desc
 */
public class Sender {

    String[] message;

    public Sender(String[] message) {
        this.message = message;
        this.fetcher = new Fetcher();
    }

    private Fetcher fetcher;

    public Fetcher getGetter() {
        return fetcher;
    }
}
