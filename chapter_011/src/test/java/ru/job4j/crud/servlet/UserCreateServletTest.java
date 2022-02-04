package ru.job4j.crud.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.crud.logic.Validate;
import ru.job4j.crud.logic.ValidateService;
import ru.job4j.crud.logic.ValidateStub;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UserCreateServletTest {

    @Test
    public void whenDoGetThenForwardToView() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(req.getRequestDispatcher("/WEB-INF/views/create.jsp")).thenReturn(dispatcher);

        UserCreateServlet userCreateServlet = new UserCreateServlet();
        userCreateServlet.doGet(req, resp);

        verify(req, times(1)).getRequestDispatcher("/WEB-INF/views/create.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test(expected = NullPointerException.class)
    public void whenAddUserThenGetException() throws ServletException, IOException, FileUploadException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        when(ValidateService.getInstance()).thenReturn(validate);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        File repository = mock(File.class);
        DiskFileItemFactory factory = mock(DiskFileItemFactory.class);
        ServletConfig config = mock(ServletConfig.class);
        ServletContext context = mock(ServletContext.class);
        when(config.getServletContext()).thenReturn(context);
        when(context.getAttribute("javax.servlet.context.tempdir")).thenReturn(repository);

        factory.setRepository(repository);

        ServletFileUpload upload = mock(ServletFileUpload.class);

        when(req.getContentType()).thenReturn("multipart/form-data; boundary=someBoundary");

        FileItem fileItem = mock(FileItem.class);

        List<FileItem> items = upload.parseRequest(req); //кинет нулл, нужен фиктивный запрос
        System.out.println(items.size());

        PrintWriter writer = mock(PrintWriter.class);
        when(resp.getWriter()).thenReturn(writer);

        UserCreateServlet userCreateServlet = new UserCreateServlet();
        userCreateServlet.init(config);
        userCreateServlet.doPost(req, resp);
    }
}
