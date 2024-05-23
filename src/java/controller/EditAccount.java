        /*
         * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
         * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
         */

        package controller;

        import dal.DAO;
        import java.io.IOException;
        import java.io.PrintWriter;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import java.sql.SQLException;
        import java.util.logging.Level;
        import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
        import model.Accounts;

        /**
         *
         * @author admin
         */
        @WebServlet(name="EditAccount", urlPatterns={"/editaccount"})
        public class EditAccount extends HttpServlet {

            /** 
             * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
             * @param request servlet request
             * @param response servlet response
             * @throws ServletException if a servlet-specific error occurs
             * @throws IOException if an I/O error occurs
             */
                private static final String GMAIL_REGEX = "^[A-Za-z0-9._%+-]+@gmail\\.com$";

           protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");

                int accountID = Integer.parseInt(request.getParameter("AccountID"));
                String taiKhoan = request.getParameter("TaiKhoan");
                String password = request.getParameter("Password");
                String roleParam = request.getParameter("Role");
                String hoVaTen = request.getParameter("HoVaTen");
                String email = request.getParameter("Email");
                int cccd = Integer.parseInt(request.getParameter("CCCD"));
                String diaChi = request.getParameter("DiaChi");

                int role;
                try {
                    role = Integer.parseInt(roleParam);
                    if (role != 0 && role != 1) {
                        throw new NumberFormatException("Invalid role value");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Role must be  0 or 1");
                    request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, 0, hoVaTen, email, cccd, diaChi)); // Maintain input data
                    request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
                    return;
                }

                
        Pattern pattern = Pattern.compile(GMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            request.setAttribute("errorMessage", "Invalid Gmail format. Email must end with '@gmail.com'.");
            request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi));
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            return;
        }



                Accounts account = new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi);
                DAO dao = new DAO();
                try {
                    dao.updateAccount(account);
                } catch (SQLException ex) {
                    Logger.getLogger(EditAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("listaccount");
            }

            // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
            /** 
             * Handles the HTTP <code>GET</code> method.
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
             * @return a String containing servlet description
             */
            @Override
            public String getServletInfo() {
                return "Short description";
            }// </editor-fold>

        }
