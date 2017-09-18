package enterprise.web_jpa_war.servlet;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;


@WebServlet(name="ListarPessoaServlet", urlPatterns={"/ListarPessoas"})
public class ListarPessoaServlet extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            //query for all the persons in database
            List professor = em.createQuery("select p from Professor p").getResultList();
            request.setAttribute("listaProfessores",professor);
            
            List aluno = em.createQuery("select a from Aluno a").getResultList();
            request.setAttribute("listaAlunos",aluno);
            
            //Forward to the jsp page for rendering
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
        return "ListarPessoa servlet";
    }
}
