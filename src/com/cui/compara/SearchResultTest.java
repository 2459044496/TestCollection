package com.cui.compara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/5 13:46
 */
public class SearchResultTest {
    public static void main(String[] args) {
        SearchResult searchResult1 = new SearchResult(10,1000);
        SearchResult searchResult2 = new SearchResult(8,2000);
        SearchResult searchResult3 = new SearchResult(10,800);

        System.out.println(searchResult1.compareTo(searchResult2));
        System.out.println(searchResult2.compareTo(searchResult3));
        SearchResult[] list = {searchResult1,searchResult2,searchResult3};
        Arrays.sort(list);
        Arrays.stream(list).forEach(System.out :: println);
    }
}
