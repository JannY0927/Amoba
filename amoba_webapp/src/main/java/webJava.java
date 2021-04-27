import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class webJava extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //config.getServletContext().getServerInfo()
        System.out.println(config.getServletContext().getServerInfo());
        super.init(config);
}

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req,res);
        System.out.println(this.getServletName() + "service");
        System.out.println(req);

    }

    @Override
    public void destroy() {
        System.out.println(this.getServletName() + "destroy");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget ");
        req.getParameterNames();

        //resp.setContentType("text/html");
        //PrintWriter write = resp.getWriter();

        //write.append("email: " +req.getParameter("email") + "<br>");
        //write.append("Pass:" +req.getParameter("password") +"<br>");
    }
}
