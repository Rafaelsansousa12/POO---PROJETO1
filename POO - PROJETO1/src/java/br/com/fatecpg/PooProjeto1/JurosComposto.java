/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.PooProjeto1;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
@WebServlet(name = "JurosComposto", urlPatterns = {"/juros-composto.html"})
public class JurosComposto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                       out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<style type=\"text/css\" media=\"screen\"  >\n" +
"        .fonte {\n" +
"            color: #d9dbe3; font-family: Arial, Helvetica, sans-serif;\n" +
"            text-align: center;\n" +
"        }\n" +
"        .fontef {\n" +
"            color: #d9dbe3; font-family: Arial, Helvetica, sans-serif;\n" +
"            text-align: center;\n" +
"            margin-left: -550px;\n" +
"        }\n" +
"        .cabeca {\n" +
"            color: #29255d; font-family: Arial, Helvetica, sans-serif;\n" +
"            text-align: left;\n" +
"            background-color: #d9dbe3;\n" +
"            padding: 20px;\n" +
"        }\n" +
"        .rodape {\n" +
"            color: #29255d; font-family: Arial, Helvetica, sans-serif;\n" +
"            text-align: left;\n" +
"            background-color: #d9dbe3;\n" +
"            padding: 8px;\n" +
"        }\n" +
"        \n" +
"        input[type=text] {\n" +
"            width: 50%;\n" +
"            padding: 12px 20px;\n" +
"            margin: 8px 0;\n" +
"            box-sizing: border-box;\n" +
"            border: 2px solid #d9dbe3;\n" +
"            border-radius: 8px;\n" +
"        }\n" +
"        .botao{\n" +
"            font-size:15px; margin-left: auto;\n" +
"            font-family: Arial, Helvetica, sans-serif;\n" +
"            font-weight:bold;\n" +
"            color: #d9dbe3;\n" +
"            background:#283b91;\n" +
"            border:0px;\n" +
"            border-radius: 8px;\n" +
"            width:120px;\n" +
"            height:30px;\n" +
"        }\n" +
"         .botao{\n" +
"            font-size:15px; margin-left: auto;\n" +
"            font-family: Arial, Helvetica, sans-serif;\n" +
"            font-weight:bold;\n" +
"            color: #d9dbe3;\n" +
"            background:#283b91;\n" +
"            border:0px;\n" +
"            border-radius: 8px;\n" +
"            width:120px;\n" +
"            height:30px;\n" +
"        }\n" +
"        .botaoref{\n" +
"            font-size:15px; margin-left: auto;\n" +
"            font-family: Arial, Helvetica, sans-serif;\n" +
"            font-weight:bold;\n" +
"            color: #29255d;\n" +
"            background:#d9dbe3;\n" +
"            border:0px;\n" +
"            border-radius: 8px;\n" +
"            width:120px;\n" +
"            height:30px;\n" +
"        }\n" +
"    </style>");   
                    
                out.println("<meta charset=\"UTF-8\">");
                out.println("</head>");
                out.println("<body style=\"background-color: #29255d\">");
                
			out.println("<h2 class=\"fonte\">Projeto 01 - POO</h2>");
                        out.println("<h1 class=\"cabeca\">JurosComposto</h1>");
                     
                        out.println("<h3 class=\"fonte\">J = C . i . t</h3>");
                        out.println("<h3 class=\"fonte\">M = J + C</h3>");
                        out.println("<h3 class=\"fonte\">J = juros <br/>M = Montante<br/>C = Capital <br/>i = Taxa de Juros <br/>t = Período</h3></div>");
                      
                        out.println("<form>");
                        out.println("<div align=\"center\">");
                        out.println("<b class=\"fontef\">Capital</b><br/>");
                        out.println("<input type='text' name='capital' /><br/>");
                        out.println("<b class=\"fontef\">Taxa</b><br/>");
                        out.println("<input type='text' name='taxa'/><br/>");
                        out.println("<b class=\"fontef\">Mês</b><br/>");
                        out.println("<input type='text' name='mes'/><br/><br/>");
                        out.println("<input class='botao' type='submit' name='montante' value ='Calcular montante'/>");
            if (request.getParameter("montante")!=null){
                try{
                    double capital = Double.parseDouble(request.getParameter("capital"));
                    double taxa = Double.parseDouble(request.getParameter("taxa"));
                    int mes  = Integer.parseInt(request.getParameter("mes"));
                    out.println("<table>");
                    for (int i=1; i<mes+1; i++){
                         out.println("<tr>");
                         out.println("<td>"+ i +"º mês </td>");
                         /*double n = Math.ceil(capital * Math.pow(1 +(taxa/100),i));*/
                         double n = capital * Math.pow(1 +(taxa/100),i);
                         BigDecimal bd = new BigDecimal(n).setScale(2, RoundingMode.HALF_EVEN);
                         out.println("<td>R$ "+ bd +"</td>");
                         out.println("</tr>");
                }
                    out.println("</table>");
                    /*  double montante = Math.ceil(capital * Math.pow(1 +(taxa/100),mes));*/
                    double montante = capital * Math.pow(1 +(taxa/100),mes);
                    BigDecimal bd = new BigDecimal(montante).setScale(2, RoundingMode.HALF_EVEN);
                    out.println("<h1>A aplicação de R$ "+ capital +" a taxa de "+ taxa +" % ao mês, durante "+ mes +" mês(s), dará um montante no valor de R$ "+ bd +"</h1>");
                }catch (NumberFormatException ex){
                    out.println("<h2 style='color:red;'>Erro ao calcular os campos</h2>");
                }
            }
                       out.println("<br/>");
                       out.println("<br/>");
                       out.println("<br/>");
                       out.println("</div>");
                       out.println("<button  class='botaoref'><a href='index.html'>Voltar</a></button>"); 
                       out.println("</form>");                                                                                                            
                       out.println("<h5 class=\"rodape\">By: Fernando Pedrozo; Luiz Henrique Carminati; Rafael dos Santos. </h5>");                                                                                                            
                out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
