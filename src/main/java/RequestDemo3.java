import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String city = request.getParameter("city");
        String[] hobies = request.getParameterValues("hoby");
        String info = request.getParameter("info");
        //打印
        System.out.println("用户名：" + username );
        System.out.println("密码：" + password );
        System.out.println("性别：" + sex );
        System.out.println("城市：" + city );
        for (String s: hobies) {
            System.out.println("爱好：" + s);
        }
        System.out.println("自我介绍：" + info );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
