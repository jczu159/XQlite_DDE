package com.exceldde;/*
 * Copyright 2009 www.pretty-tools.com. All rights reserved.
 */

import com.pretty_tools.dde.client.DDEClientConversation;

import java.util.Timer;

/**
 * Excel Example.
 *
 * @author Alexander Kozlov
 */
public class ExcelExample {

    //進入之後初始化 - V 1.0
    private final static DDEClientConversation conversation = new DDEClientConversation();


    public static void main(String[] args) {
        conversation.setTimeout(3000);
        try {
            conversation.connect("Excel", "C:\\Users\\user\\Desktop\\Excel.xlsx");
            Timer timer = new Timer();
            timer.schedule(new SynchronizingTask(conversation), 1000, 1000 * 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}