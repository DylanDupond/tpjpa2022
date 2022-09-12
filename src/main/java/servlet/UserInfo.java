package servlet;
import Repository.UserRepository;
import jpa.EntityManagerHelper;
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",
        urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {

    UserRepository repository;
    EntityManager manager;
    EntityTransaction tx;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserRepository repository = new UserRepository();
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        StringBuilder UsersInfo = new StringBuilder();

        for (User user :  repository.getAllUsers(manager)) {
            UsersInfo.append("<li>").append(user.getFirstName()).append(" ").append(user.getLastName()).append("</li>");
        }

        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print(
                "<HTML>\n<BODY>\n" +
                        "<ul>" +
                            UsersInfo +
                        "</ul>" +
                        "</BODY></HTML>");
        p.flush();

    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        User user = new User();
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setMdp(request.getParameter("mdp"));

        UserRepository repository = new UserRepository();
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        try {
            manager.persist(user);

            repository.addUser(user, manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Utilisateur enregistré !</H1>\n" +
                "</BODY></HTML>");

    }

    public void destroy() {
        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
