package com.bjsxt.proxy;
import java.lang.reflect.Method;
public class Tank2 implements Moveable{
 @Override
public void move() {
             Tank t=new Tank();
             long startTime= System.currentTimeMillis();     
             t.move();
             long endTime= System.currentTimeMillis();
             System.out.println("totalTime:"+(endTime-startTime));
            }
     }