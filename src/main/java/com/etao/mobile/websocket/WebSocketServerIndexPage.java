package com.etao.mobile.websocket;
import org.jboss.netty.buffer.ChannelBuffer;
 import org.jboss.netty.buffer.ChannelBuffers;
 import org.jboss.netty.util.CharsetUtil;

import java.io.*;

/**
  * Generates the demo HTML page which is served at http://localhost:8080/
  * <P>Description: TODO(用一句话描述该文件做什么) </P>
  * @ClassName: WebSocketServerIndexPage 
  * @author guojw  2014年5月14日 上午11:03:10 
  * @see WebSocketServerIndexPage
  */
 public final class WebSocketServerIndexPage {

     private static final String NEWLINE = "\r\n";

     public static ChannelBuffer getContent(String webSocketLocation) {
         return ChannelBuffers
                 .copiedBuffer(readFileIndexHtml(), CharsetUtil.US_ASCII);
     }

     private static String readFileIndexHtml() {
         String fileContent = "";
         try {
             FileReader fileReader = new FileReader("d://websocket.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             String temp = null;
             StringBuffer sb = new StringBuffer();
             while((temp = bufferedReader.readLine()) != null) {
                sb.append(temp);
             }
             fileContent = sb.toString();
             bufferedReader.close();
             fileReader.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return fileContent;
     }

     private WebSocketServerIndexPage() {
         // Unused
     }
 }