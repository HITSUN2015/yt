package com.yt.design.pattern.action.observer;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 上午9:16
 * @desc
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}