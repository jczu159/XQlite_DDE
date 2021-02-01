package com.exceldde;

import com.pretty_tools.dde.DDEException;
import com.pretty_tools.dde.client.DDEClientConversation;

import java.util.Date;
import java.util.TimerTask;

/**
 * 一秒鐘執行一次獲取DDE資料
 */
public class SynchronizingTask extends TimerTask {

    //進入之後初始化 - V 1.0
    private DDEClientConversation conversation;


    public SynchronizingTask(DDEClientConversation conversation) {
        this.conversation = conversation;
    }


    @Override
    public void run() {
        System.out.println("任務時間：" + new Date());
        try {
            //R代表第二行(橫)  C代表第列  (豎)
    /*        System.out.println("A1 value: " + conversation.request("R1C1"));
            System.out.println("A1 value: " + conversation.request("R2C2"));*/

            //累積委買口數
            System.out.println(conversation.request("R1C3").trim() + ":" + conversation.request("R2C3").trim());
            //累積委賣口數
            System.out.println(conversation.request("R1C5").trim() + ":" + conversation.request("R2C5").trim());

            Integer lotDifference = Integer.valueOf(conversation.request("R2C3").trim()) - Integer.valueOf(conversation.request("R2C5").trim());
            System.out.println("口數差異" + lotDifference);
            //累積委買筆數
            System.out.println(conversation.request("R1C4").trim() + ":" + conversation.request("R2C4").trim());
            //累積委賣筆數
            System.out.println(conversation.request("R1C6").trim() + ":" + conversation.request("R2C6").trim());

            Integer countDifference = Integer.valueOf(conversation.request("R2C4").trim()) - Integer.valueOf(conversation.request("R2C6").trim());
            System.out.println("筆數差異" + countDifference);

        } catch (DDEException e) {
            e.printStackTrace();
        }
    }

}
