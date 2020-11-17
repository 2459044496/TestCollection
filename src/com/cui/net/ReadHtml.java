package com.cui.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/9/26 14:55
 */
public class ReadHtml {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(url.openStream()));
            System.out.println(url.getDefaultPort());
            System.out.println(url.getHost() + url.getAuthority());
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();
        } catch (Exception e) {

        } finally {

        }
    }
}
