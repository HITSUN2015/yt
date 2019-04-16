package com.yt.design.pattern.action.observer;/**
 * Created by SUN on 19/3/23.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN
 * @create 2019-03-23 上午9:15
 * @desc
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
