package com.cui.map;

import com.cui.compara.SearchResult;
import com.cui.compara.SearchResultComparator;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 17:48
 */
public class TreeMapTest {
    public static void main(String[] args) {
        SearchResultComparator searchResultComparator = new SearchResultComparator();

        TreeMap treeMap = new TreeMap(searchResultComparator);
        SearchResult searchResult1 = new SearchResult(10,1000);
        SearchResult searchResult2 = new SearchResult(8,2000);

        treeMap.put(searchResult1,"10");
        treeMap.put(searchResult2,"20");

    }
}
