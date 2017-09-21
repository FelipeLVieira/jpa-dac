package servlet;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.Professor;



@WebServlet(name="CriarProfessorServlet", urlPatterns={"/CriarProfessorServlet"})
public class CriarProfessorServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "web-jpaPU")
    private EntityManagerFactory emf;  
    
    @Resource
    private UserTransaction utx;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException {
        assert emf != null;
        EntityManager em = null;
        try {
            
            String nome  = (String) request.getParameter("nome");
            String email   = (String) request.getParameter("email");
            String titulacao   = (String) request.getParameter("titulacao");
            

            Professor professor = new Professor(0l, nome, email, titulacao);

            utx.begin();
            em = emf.createEntityManager();
            em.persist(professor);
            utx.commit();
            
            List professores = em.createQuery("select p from Professor p order by p.nome").getResultList();
            request.setAttribute("listaProfessores",professores);
            
            request.getRequestDispatcher("ListarPessoas.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
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
