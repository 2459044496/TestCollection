package com.cui.bookreadingfeel.javaconcurrencyinpractice.testpack;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 17:05
 */
public class SubscriptionObserver implements Observer{
    private double price;
    private Subject subscriberGrabber;
    private int subscriptionID = 1;

    // 通过SubscriptionObserver的构造方法新增观察者
    public SubscriptionObserver(Subject subscriberGrabber) {
        this.subscriberGrabber = subscriberGrabber;
        this.subscriptionID += 1;
        subscriberGrabber.addNewSubscriber(this);
        System.out.println("New Observer: " + this.subscriptionID);
    }

    @Override
    public void update(double price) {
        // update操作
        System.out.println("price change from" + this.price + " to " + price);
        this.price = price;
    }
}
