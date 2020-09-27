import javax.servlet.*;
import java.io.IOException;

public class ServletDemo implements Servlet {

    /*
        Servlet对象一被实例化那么Servlet中的init方法就会执行（init只会执行一次）
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
