package com.cui.bookreadingfeel.javaconcurrencyinpractice.testpack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 17:00
 */
public class SubscriptionGrabber implements Subject{
    // 存放所以观察者
    private List<Observer> subscribers = new ArrayList<>();
    private double price;

    public SubscriptionGrabber() {
        subscribers = new ArrayList<>();
    }

    @Override
    public double getCurrentPrice() {
        return price;
    }

    @Override
    public void setNewPrice(double newPrice) {
        this.price = newPrice;
        // 更新价格时通知所以观察者
        this.notifyAllSubscribers();
    }

    @Override
    public void addNewSubscriber(Observer newSuObserver) {
        subscribers.add(newSuObserver);
    }

    @Override
    public void removeSubscriber(Observer unsubscriber) {
        // 获取观察者下标
        int indexOfUnsubscriber = subscribers.indexOf(unsubscriber);
        subscribers.remove(indexOfUnsubscriber);
    }

    @Override
    public void notifyAllSubscribers() {
        for (Observer subscriber : subscribers) {
            subscriber.update(price);
        }
    }
}
