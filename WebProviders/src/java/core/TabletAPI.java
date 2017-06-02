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
@WebServlet("/tabletApi")
public class TabletAPI extends HttpServlet {

    public static final String TABLET_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"tab1\",\"productName\":\"HUAWEI MediaPad M2 \",\"productPrice\":250.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/HUAWEIMediaPadM2.jpg\"},"
            + "{\"productId\":\"tab2\",\"productName\":\"iPad mini 4 Wi-Fi 4G 32GB\",\"productPrice\":650.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/iPadmini4Wi-Fi4G32GB.jpg\"},"
            + "{\"productId\":\"tab3\",\"productName\":\"Samsung Tab S2 8 inch\",\"productPrice\":550.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/SamsungTabS28inch.jpg\"},"
            + "{\"productId\":\"tab4\",\"productName\":\"Asus ZenPad Z370CG\",\"productPrice\":350.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/AsusZenPadZ370CG.jpg\"},"
            + "{\"productId\":\"tab5\",\"productName\":\"Lenovo Tab 2 A7-30\",\"productPrice\":250.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/LenovoTab2A7-30.jpg\"},"
            + "{\"productId\":\"tab6\",\"productName\":\"Masstel Tab 715\",\"productPrice\":230.0,\"supplierId\":\"S001\",\"info\":\"/WebProviders/images/MasstelTab715.jpg\"}]}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(TABLET_JSON_STRING);
    }

}
