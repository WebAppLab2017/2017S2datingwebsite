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
@WebServlet("/phoneApi")
public class PhoneAPI extends HttpServlet {

    public static final String JSON_STRING = "{\"products\":["
            + "{\"productId\":\"P010\",\"productName\":\"Iphone 6sssssss\",\"productPrice\":350.0,\"supplierId\":\"S001\",\"info\":\"\"},"
            + "{\"productId\":\"P011\",\"productName\":\"Samsung Galaxy J7 Prime\",\"productPrice\":850.0,\"supplierId\":\"S001\",\"info\":\"\"},"
            + "{\"productId\":\"P012\",\"productName\":\"Oppo F1s\",\"productPrice\":450.0,\"supplierId\":\"S001\",\"info\":\"\"},"
            + "{\"productId\":\"P013\",\"productName\":\"Microsoft Lumia 950\",\"productPrice\":350.0,\"supplierId\":\"S001\",\"info\":\"\"},"
            + "{\"productId\":\"P014\",\"productName\":\"HTC One M9\",\"productPrice\":250.0,\"supplierId\":\"S001\",\"info\":\"\"},"
            + "{\"productId\":\"P015\",\"productName\":\"Asus Zenphone 5\",\"productPrice\":2250.0,\"supplierId\":\"S001\",\"info\":\"\"}]}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(JSON_STRING);
    }

}
