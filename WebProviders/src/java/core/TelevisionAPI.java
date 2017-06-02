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
@WebServlet("/televisionApi")
public class TelevisionAPI extends HttpServlet {

    public static final String TELEVISION_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"tv1\",\"productName\":\"TV LGs 32 inch 32LF550D\",\"productPrice\":210.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/TiviLG32inch32LF550D.jpg\"},"
            + "{\"productId\":\"tv2\",\"productName\":\"TV Toshiba 24 inch 24S2550\",\"productPrice\":150.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/TiviToshiba24inch24S2550.jpg\"},"
            + "{\"productId\":\"tv3\",\"productName\":\"TV Samsung 32 inch UA32J4100\",\"productPrice\":450.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/TiviSamsung32inchUA32J4100.jpg\"},"
            + "{\"productId\":\"tv4\",\"productName\":\"TV Sony 32 inch KDL-32R300C\",\"productPrice\":350.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/TiviSony32inchKDL-32R300C.jpg\"},"
            + "{\"productId\":\"tv5\",\"productName\":\"Smart TV TCL 32 inch L32S6100\",\"productPrice\":250.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/SmartTiviTCL32inchL32S6100.jpg\"},"
            + "{\"productId\":\"tv6\",\"productName\":\"TV Panasonic 40 inch TH-40C400V\",\"productPrice\":280.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/TiviPanasonic40inchTH-40C400V.jpg\"}]}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(TELEVISION_JSON_STRING);
    }

}
