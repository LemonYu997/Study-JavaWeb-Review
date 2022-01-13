package filedownload.servlet;

import filedownload.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");

        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);

        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type", mimeType);

        String agent = req.getHeader("user-agent");
        String fileName = DownloadUtils.getFileName(agent, filename);
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);

        ServletOutputStream os = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read()) != -1) {
            os.write(buff, 0, len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
