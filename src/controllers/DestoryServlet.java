package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TasksDTO;
import utils.DBUtil;

/**
 * Servlet implementation class DestoryServlet
 */
@WebServlet("/destory")
public class DestoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            TasksDTO t = em.find(TasksDTO.class, (Integer)(request.getSession().getAttribute("TasksDTO_id")));

            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("tasksDTO_id");
            response.sendRedirect(request.getContextPath()+"/index");
        }
    }

}
