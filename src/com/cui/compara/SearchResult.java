package com.cui.compara;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 13:39
 * 自然排序就是人们常识认知的升序排序，如1、2、3，a、b、c
 * 实现Comparable接口可以自定义排序，覆写compareTo接口
 * 小于的情况-1，等于0，大于1
 */
public class SearchResult implements Comparable<SearchResult>{

    int relativeRatio;
    long count;
    int recentOrders;

    public SearchResult(int relativeRatio, long count) {
        this.relativeRatio = relativeRatio;
        this.count = count;
    }

    @Override
    public int compareTo(SearchResult o) {
        // 先根据relativeRatio比较
        if (this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }
        // 在根据count比较
        if (this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }
        return 0;
    }

    public void SearchResult(int recentOrders) {
        this.recentOrders = recentOrders;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "relativeRatio=" + relativeRatio +
                ", count=" + count +
                ", recentOrders=" + recentOrders +
                '}';
    }
}
