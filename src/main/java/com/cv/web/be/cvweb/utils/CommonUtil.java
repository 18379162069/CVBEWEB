package com.cv.web.be.cvweb.utils;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Description: 公共工具类
 * @author: Henry
 * @Date: 2015年4月15日
 * @version: 1.0
 */
public class CommonUtil {

    private static final Logger LOG = Logger.getLogger(CommonUtil.class);

    public static final Pattern IP_PATTERN = Pattern.compile("^\\d+\\.\\d+\\.\\d+\\.\\d+$");

    /**
     * @Definition: 微信状态 json 转 Map.
     * @author: Henry
     * @Date: 2015年4月15日
     * @return: String String.
     */
    public static Map<String, String> weChatString2Map(String ja) {
        // json转map
        Map<String, String> weChatMap = new HashMap();
        for (int i = 0; i < ja.length(); i++) {
            ja.split(",", 8);

        }
        return weChatMap;
    }

    /**
     * @Definition: 判断非空.
     * @author: Henry
     * @Date: 2015年4月22日
     * @param: argObj object对象
     * @return: boolean boolean
     */
    public static boolean isNotNull(Object argObj) {
        return !CommonUtil.isNull(argObj);
    }


    /**
     * @Definition: 判断为空.
     * @author: Henry
     * @Date: 2015年4月22日
     * @param: argObj object对象
     * @return: boolean boolean
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNull(Object argObj) {

        if (argObj == null) {
            return true;
        }

        if (argObj instanceof String) {

            if (((String) argObj).trim().equals("") || ((String) argObj).trim().equals(" ")
                    || ((String) argObj).trim().equals("null")) {
                return true;
            }
        }

        if (argObj instanceof Collection) {

            if (((Collection) argObj).size() == 0) {
                return true;
            }
        }

        if (argObj instanceof Map) {

            if (((Map) argObj).size() == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * @throws :
     * @Definition: 正则表达判断是邮箱还是手机
     * @author: Henry
     * @Date: 2015年4月22日
     * @param: number
     * @return: 1.手机 2.邮箱
     */
    public static int isEmailOrMobile(String number) {
        int flag = 0;
        String emailRegex = "^([\\w\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        String mobileRegex = "^(1)\\d{10}$";
        try {
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(number);
            if (matcher.matches()) {
                flag = 2;
            } else {
                pattern = Pattern.compile(mobileRegex);
                matcher = pattern.matcher(number);
                if (matcher.matches()) {
                    flag = 1;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            flag = 0;
        }
        return flag;
    }

    /**
     * 是否是邮件.
     *
     * @param mailAddress mailAddress
     */
    public static Boolean isEmailAddress(String mailAddress) {
        Boolean bol = false;
        String emailRegex = "^([\\w\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        try {
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(mailAddress);
            if (matcher.matches()) {
                bol = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            bol = false;
        }
        return bol;
    }

    /**
     * @Definition: 把对象转换成map，只支持一层.
     * @author: chenyongqiang
     * @Date: 2015年5月5日
     */
    public static Map<String, Object> objectToMap(Object object) {
        Map<String, Object> map = null;
        try {
            if (object != null) {
                map = new HashMap<String, Object>();
                Class cls = object.getClass();
                Method[] ms = cls.getMethods();
                for (Method mt : ms) {
                    Class[] mcls = mt.getParameterTypes();
                    if (mcls != null && mcls.length > 0) {
                        continue;
                    }
                    String name = mt.getName();
                    if (name.startsWith("get")) {
                        Object value = mt.invoke(object);
                        String field = name.substring(3, 4).toLowerCase() + name.substring(4);
                        if ("class".equals(field)) {
                            continue;
                        }
                        map.put(field, value);
                    }
                }
            }
        } catch (Exception exception) {
            LOG.debug("把对象转换成Map时出错！", exception);
        }
        return map;
    }

    /**
     * @param request request
     * @Definition: 获取客户端的公网（外网）ip，如果浏览器处在局域网内，那么获取的是192.168.1.x，也就是局域网ip，如果本机浏览器，那么获取的是127.0.0.1
     * @author: chenyongqiang
     * @Date: 2015年12月29日
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");//真实ip，在nginx配置中补充的
        if (ip == null || !IP_PATTERN.matcher(ip).matches()) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || !IP_PATTERN.matcher(ip).matches()) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || !IP_PATTERN.matcher(ip).matches()) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || !IP_PATTERN.matcher(ip).matches()) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || !IP_PATTERN.matcher(ip).matches()) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || !IP_PATTERN.matcher(ip).matches()) {
            ip = request.getRemoteAddr();
        }
        //可能存在多个代理ip
        if (ip != null) {
            //System.out.println("访问ip： " + ip + "，时间：" + DateUtil.toString(new Date()));
            String[] ips = ip.split(",");
            for (int i = 0; i < ips.length; i++) {
                String ip2 = ips[i];
                if ("127.0.0.1".equals(ip2)) {
                    ip = ip2;
                } else if (IP_PATTERN.matcher(ip2).matches()) {
                    ip = ip2;
                    break;
                }
            }
        }
        return ip;
    }

    public static String MD5Encr (String  pwd){
        int hashIterations = 1;//加密的次数
        Object salt = null;//盐值
        Object credentials = pwd;//密码
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        return  simpleHash.toString();
    }

}
