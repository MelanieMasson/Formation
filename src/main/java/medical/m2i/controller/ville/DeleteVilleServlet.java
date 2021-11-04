package medical.m2i.controller.ville;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.VilleDao;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/deleteVille")
public class DeleteVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteVilleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		VilleDao villeDao = new VilleDao();
		System.out.println("Suppression d'un patient");
		villeDao.deleteVille(id);

		response.sendRedirect(request.getContextPath() + "/ListVilleServlet");
	}

}