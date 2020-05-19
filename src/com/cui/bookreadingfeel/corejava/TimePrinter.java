package com.cui.bookreadingfeel.corejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/19 19:10
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Now date is: " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
