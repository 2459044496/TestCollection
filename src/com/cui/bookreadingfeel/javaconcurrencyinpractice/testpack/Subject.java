package com.cui.bookreadingfeel.javaconcurrencyinpractice.testpack;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 16:58
 * 观察者的常用方法
 */
public interface Subject {
    // 获取当前价格
    public double getCurrentPrice();
    // 定义新的价格
    public void setNewPrice(double newPrice);
    // 添加新的观察者
    public void addNewSubscriber(Observer newSuObserver);
    // 移除一个观察者
    public void removeSubscriber(Observer unsubscriber);
    // 通知所有观察者
    public void notifyAllSubscribers();
}
