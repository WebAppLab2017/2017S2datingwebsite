package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IU-CSE Team
 */
@WebServlet("/laptopApi")
public class LaptopAPI extends HttpServlet {

    public static final String LAPTOP_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"lap1\",\"productName\":\"ACER AS ES1-572-388E\","
            + "\"productPrice\":650.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/ACERASES1-572-388E.jpg\"},"
            + "{\"productId\":\"lap2\",\"productName\":\"Macbook Air 13 MMGF2ZP/A\","
            + "\"productPrice\":850.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/MacbookAir13MMGF2ZPA.png\"},"
            + "{\"productId\":\"lap3\",\"productName\":\"Dell Ins N7566A\","
            + "\"productPrice\":750.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/DellInsN7566A.png\"},"
            + "{\"productId\":\"lap4\",\"productName\":\"Asus K401LB-FR119D\","
            + "\"productPrice\":550.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/AsusK401LB-FR119D.jpg\"},"
            + "{\"productId\":\"lap5\",\"productName\":\"HP ProBook 450 G3\","
            + "\"productPrice\":600.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/HPProBook450G3.jpg\"},"
            + "{\"productId\":\"lap6\",\"productName\":\"MSI GL72 6QF-807XVN\","
            + "\"productPrice\":680.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/MSIGL726QF-807XVN.jpg\"}]}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(LAPTOP_JSON_STRING);
    }

}
