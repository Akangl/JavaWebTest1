import javax.servlet.http.Cookie;
/*
    查找指定名称的Cookie的工具类
 */

public class CookieUtils {
    public static Cookie findCookie(Cookie[] cookies,String name){
        if (cookies == null){
            //浏览器没有携带任何的Cookie
            return null;
        }else {
            for (Cookie cookie : cookies){
                //判断数组中的每个cookie的名称是否跟给定名称相同
                if (name.equals(cookie.getName())){
                    //返回这个cookie
                    return cookie;
                }
            }
            //浏览器带有cookie过来了,但是没有那个指定名称的cookie
            return null;
        }
    }
}
