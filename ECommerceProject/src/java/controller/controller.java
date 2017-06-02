/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import java.io.File;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author trung
 */
@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    private Object session;

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
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String type = request.getParameter("type");
            System.out.println(action);
            if (action.equals("getproduct")) {
                System.out.println(type);
                DAO dao = new DAO();
                ArrayList<pro> product = dao.getProduct(type);
                session.setAttribute("product", product);
                dispatcher(request, response, "tablet.jsp");
            }

            if (action.equals("productDetail")) {
                int id = Integer.parseInt(request.getParameter("id"));
                DAO detail = new DAO();
                pro productDetail = detail.productDetail(id);
                session.setAttribute("productdetail", productDetail);
                dispatcher(request, response, "view.jsp");
            }
            if (action.equals("AddtoCart")) {
                System.out.println(action);
                shoppingCart cart = (shoppingCart) session.getAttribute("cart");

                if (cart == null) {
                    System.out.println("cart: " + null);
                    cart = new shoppingCart();
                }

                System.out.println("product " + session.getAttribute("productdetail"));

                pro temp = (pro) session.getAttribute("productdetail");
                int qu = temp.getQuantity();
                System.out.println("qu " + qu);
                if (qu > 0) {
                    --qu;
                    System.out.println("qu " + qu);
                    temp.setQuantity(qu);
                    //int quantity = Integer.parseInt(request.getParameter("quantity"));

                    cart.addProduct(temp);
                    System.out.println("cart " + cart.getProducts().size());
                }
                session.setAttribute("cart", cart);

            }
            if (action.equals("checkout")) {
                System.out.println(action);
                shoppingCart cart = (shoppingCart) session.getAttribute("cart");
                if (cart == null) {
                    cart = new shoppingCart();
                }
                session.setAttribute("cart", cart);
                dispatcher(request, response, "checkout.jsp");
            }

            if (action.equals("order")) {
                shoppingCart cart = (shoppingCart) session.getAttribute("cart");
                String accid = (String) session.getAttribute("login");
                DAO dao = new DAO();
                dao.order(cart, accid);
                session.removeAttribute("cart");
                response.sendRedirect("index.jsp");

            }
            if (action.equals("upload")) {

                String dirNames = "D:\\Task\\IU\\Web Application Development\\New\\Final project\\ECommerceProject";

                String user = (String) session.getAttribute("login");

                String fileName = null;
                boolean isMultiPArt = ServletFileUpload.isMultipartContent(request);

                if (isMultiPArt) {
                    System.out.println(1);
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List items = null;
                    try {
                        items = upload.parseRequest(request);
                    } catch (FileUploadException e) {
                        e.printStackTrace();
                    }
                    Iterator iter = items.iterator();
                    Hashtable params = new Hashtable();

                    File theDir = new File(dirNames + File.separator + user);

                    // if the directory does not exist, create it
                    if (!theDir.exists()) {
                        System.out.println("creating directory: " + user);
                        boolean result = false;

                        try {
                            theDir.mkdir();
                            result = true;
                        } catch (SecurityException se) {
                            //handle it
                        }
                        if (result) {
                            System.out.println("DIR created");
                        }
                    }
                    String[] url = new String[5];
                    int cnt = 0;
                    while (iter.hasNext()) {
                        FileItem item = (FileItem) iter.next();
                        if (item.isFormField()) {
                            params.put(item.getFieldName(), item.getString());
                        } else {
                            try {
                                String itemName = item.getName();
                                fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                                System.out.println("path: " + fileName);
                                String realPath = dirNames + File.separator + user + File.separator + fileName;
                                System.out.println("realPath: " + realPath);
                                File savedFile = new File(realPath);
                                item.write(savedFile);
                                url[cnt] = "./database" + File.separator + user + File.separator + fileName;
                                ++cnt;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                
                    String name = (String) params.get("name");
                    String price = (String) params.get("price");
                    String quantity = (String) params.get("quantity");
                    String typepr = (String) params.get("type");
                   
                    System.out.println(name + " " + price + " " + quantity + " " + typepr);
                    
                    DAO uploadReal = new DAO();
                   uploadReal.inserPro(name, price, quantity, typepr, url[0]);
//                        newUser = new User();
//                        newUser.setEmail(Email);
                    out.print(url[0]);
                    String temp = ".\\User" + File.separator + user + File.separator + fileName;
                    System.out.println("Temp " + temp);

                    //Connector.editUser(myProfile.getEmail(), newUser);
                    //response.sendRedirect("index.jsp");
                    dispatcher(request, response, "index.jsp");
                }

            }
        }

    }

    public void dispatcher(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);

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
