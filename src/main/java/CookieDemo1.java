import com.sun.prism.es2.ES2Graphics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
/*
    记录用户上次访问时间
 */

@WebServlet(name = "CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            用户访问Servlet
                如果是第一次访问：
                    显示：你好，欢迎来到本网站
                    记录当前访问时间，存入到Cookie,回写到浏览器
                如果不是第一次访问：
                    从Cookie记录中获取上次时间,显示到页面
                    记录当前访问时间,存入到Cookie,回写到浏览器
         */
        //判断是否是第一次访问:从指定的Cookie数组中获取指定名称的Cookie
        //获得从浏览器带过来的所有的Cookie
        Cookie[] cookies = request.getCookies();
        //从数组中找到指定名称的Cookie
        Cookie lastVisit = CookieUtils.findCookie(cookies, "lastVisit");
        //判断是否是第一次访问
        if (lastVisit == null){
            //第一次访问
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("你好，欢迎来到本网站");
            System.out.println("if");
        }else{
            //不是第一次访问
            //获得Cookie中的上一次访问时间
            String value = lastVisit.getValue();
            //显示到页面上的内容
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("您上次的访问时间为"+value);
            System.out.println("else");
        }
        System.out.println("1111");
        //记录当前访问时间
        Date date = new Date();
        //存入到Cookie
        Cookie cookie = new Cookie("lastVisit", (date.toString()));
        System.out.println("222");
        //给Cookie设置有效路径
        cookie.setPath("/Test3_war");
        System.out.println("333");
        //回写到浏览器
        response.addCookie(cookie);
        System.out.println("000");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
