package enterprise.web_jpa_war.servlet;

import java.io.IOException;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import jpa.entities.Professor;

/**
 *
 * @author felip
 */

@WebServlet(name="EditarProfessorServlet", urlPatterns={"/EditarProfessorServlet"})
public class EditarProfessorServlet extends HttpServlet {

    @PersistenceUnit
    //The emf corresponding to 
    private EntityManagerFactory emf;  
    
    @Resource
    private UserTransaction utx;
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            
            Long profId = (Long) Long.parseLong(request.getParameter("idProf"));
            
            System.out.println(request.getParameterNames().toString());
            
            utx.begin();
            em = getEntityManager();
            
            Professor professor = em.getReference(Professor.class, profId);
            professor = em.merge(professor);

            utx.commit();

            request.getRequestDispatcher("ListarPessoas.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    

    public String getServletInfo() {
        return "Short description";
    }
}
