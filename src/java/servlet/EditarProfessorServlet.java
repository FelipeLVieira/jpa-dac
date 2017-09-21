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



@WebServlet(name="EditarProfessorServlet", urlPatterns={"/EditarProfessorServlet"})
public class EditarProfessorServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "web-jpaPU")
    private EntityManagerFactory emf;  
    
    @Resource
    private UserTransaction utx;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException {
        assert emf != null;
        EntityManager em = null;
        try {
            utx.begin();
            em = emf.createEntityManager();
            
            Long id  = Long.parseLong( (String) request.getParameter("idSalvar"));
            
            Professor professor = (Professor) em.getReference(Professor.class, id);
            
            if (professor != null) {
                    professor.setNome((String) request.getParameter("nome"));
                    professor.setEmail((String) request.getParameter("email"));
                    professor.setTitulacao((String) request.getParameter("titulacao"));
                    em.merge(professor);
            }
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
