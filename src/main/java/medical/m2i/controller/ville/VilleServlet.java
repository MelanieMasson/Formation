package medical.m2i.controller.ville;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.VilleDao;
import medical.m2i.model.Ville;

/**
 * Servlet implementation class Test
 */
@WebServlet("/registerVille")
public class VilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VilleDao villeDao;

	public void init() {
		villeDao = new VilleDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VilleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Je suis bien dans la méthode post");
		String nom = request.getParameter("nom");
		String pays = request.getParameter("pays");
		String code_postal = request.getParameter("code_postal");

		Ville ville = new Ville();
		ville.setNom(nom);
		ville.setPays(pays);
		ville.setCode_postal(code_postal);

		try {
			villeDao.registerVille(ville);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		response.setContentType(" text / html ");
//		PrintWriter out = response.getWriter();
//		out.println("<html >");
//		out.println("<body >");
//		out.println("<h1 > Bonjour " + prenom + " " + nom + " ! </h1 >");
//		out.println("<p>Vous êtes né le : " + naissance + "</p>"); // la date de naissance
//		out.println("<p>Votre adresse est : " + adresse + "</p>"); // � la place des **** : adresse + pays + ville
//		out.println("<p>Votre pays est : " + pays + "</p>"); // � la place des **** : adresse + pays + ville
//		out.println("<p>Votre ville est : " + ville + "</p>"); // � la place des **** : adresse + pays + ville
//		out.println(" </body >");
//		out.println(" </html >");

		response.sendRedirect(request.getContextPath() + "/ListVilleServlet");
	}

}