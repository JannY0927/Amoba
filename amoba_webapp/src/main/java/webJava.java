import hu.alkfejl1.Game;
import hu.alkfejl1.Player;
import hu.alkfejl1.db.PlayedGameDb;
import hu.alkfejl1.db.PlayedGameDbImp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/webjava")
public class webJava extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public webJava() {
        super();
    }

   /* @Override
    public void init(ServletConfig config) throws ServletException {
        //config.getServletContext().getServerInfo()

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req,res);
        System.out.println(this.getServletName() + "service");
        System.out.println("mikor?");
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
        resp.setContentType("text/html");
        System.out.println("doget ");
        System.out.println(req);
        System.out.println(req.getParameter("jani"));
        //write.append("email: " +req.getParameter("email") + "<br>");
        //write.append("Pass:" +req.getParameter("password") +"<br>");
    }*/
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String sign = request.getParameter("sign");

        System.out.println("x: "+ x + " y: "+ y + " sign: " + sign);
      //  System.out.println(y);
        PlayedGameDb gpd = new PlayedGameDbImp();
        int maxGameId = 0;
        try {
            maxGameId = gpd.maxGameId();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (sign == "") {
            gpd.insert(maxGameId+1, Integer.parseInt(x), Integer.parseInt(y), sign);
        }
        else {
            gpd.insert(maxGameId, Integer.parseInt(x), Integer.parseInt(y), sign);
        }


        //response.setContentType("text/plain");
        //response.getWriter().write(greetings);
    }
}
