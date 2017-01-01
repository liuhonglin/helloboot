package com.test.hello.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HL.L on 2017/1/1.
 */
@Controller
@RequestMapping(value = "/say")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello(String name, Map<String, Object> model, HttpServletRequest request) {

        String ip = URLUtil.getIpAddr(request);

        System.out.println("-------------------> IP = " + ip);
        logger.info("-------------------> IP = " + ip);

        model.put("stra", name);
//        if(name != null && name.length()>0) {
//            name = name.replaceAll("!", "%");
//            try {
//                name = URLDecoder.decode(name, "utf-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("-------------------> happy = " + name);
        logger.info("-------------------> happy = " + name);


        String Agent = request.getHeader("User-Agent");
        StringTokenizer st = new StringTokenizer(Agent,";");
        st.nextToken();
        //得到用户的浏览器名
        String userbrowser = st.nextToken();
        //得到用户的操作系统名
        //String useros = st.nextToken();

        System.out.println("userbrowser = " + userbrowser);
        //System.out.println("useros =" + useros);
        logger.info("userbrowser = " + userbrowser);
       //logger.info("useros = " + useros);

        String remoteUser = request.getRemoteUser();
        String remoteHost = request.getRemoteHost();

        System.out.println("-------------------> remoteUser =" + remoteUser);
        System.out.println(" ------------------->remoteHost = " + remoteHost);

        logger.info("-------------------> remoteUser =" + remoteUser);
        logger.info("-------------------> remoteHost = " + remoteHost);


        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        model.put("basePath", basePath);

//        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
//
//        Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
//        Matcher matcher = pattern.matcher(userAgent);
//        String model = null;
//        if (matcher.find()) {
//            model = matcher.group(1).trim();
//            log.debug("通过userAgent解析出机型：" + model);
//        }

//        try {
//            InetAddress address = InetAddress.getLocalHost();
//
//            String hostName = address.getHostName();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }


        return "happy";
    }
}
