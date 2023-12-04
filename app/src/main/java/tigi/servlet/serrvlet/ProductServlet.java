package tigi.servlet.serrvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import tigi.servlet.model.SanPham;
import tigi.servlet.repository.ProductRepository;
import tigi.servlet.util.tigi.converter.UUIDFromString;
import tigi.servlet.util.tigi.http.FormRequest;
import tigi.servlet.util.tigi.http.HttpMethod;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.UUID;

@WebServlet(value = {
        "/product",
        "/product/add",
        "/product/detail",
        "/product/update",
        "/product/delete"
})
public class ProductServlet extends HttpServlet {

    private ProductRepository repository;

    public ProductServlet() {
        this.repository = new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormRequest.setform(req, "/product/add", HttpMethod.POST);

        String uri = req.getRequestURI();

        if (uri.contains("/product/detail")) {
            UUID id = UUID.fromString(req.getParameter("id"));
            Optional<SanPham> sp = Optional.ofNullable(repository.findById(id));

            sp.ifPresentOrElse(o -> {
                req.setAttribute("product", o);
            }, () -> {
                req.setAttribute("notify", "cannot find product");
            });

        }

        if (uri.contains("/update")) {
            UUID id = UUID.fromString(req.getParameter("id"));

            Optional.ofNullable(repository.findById(id)).ifPresentOrElse(o -> {
                req.setAttribute("product", o);
                System.out.println(o.getId() + "\n\n\n\n\n");
                FormRequest.setform(req, "/product/update", HttpMethod.POST);
            }, () -> {
                req.setAttribute("notify", "cannot find product");
            });
        }

        if (uri.contains("/delete")) {
            UUID id = UUID.fromString(req.getParameter("id"));

            Optional.ofNullable(repository.remove(repository.findById(id))).ifPresentOrElse(o -> {
                System.out.println("id: " +  id);
                req.setAttribute("notify", "removed product");
            }, () -> {
                req.setAttribute("notify","cannot remove prodct");
            });
        }

        req.setAttribute("products", this.repository.getAll());
        req.getRequestDispatcher("/product.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/add")) {
            SanPham sp = new SanPham();
            try {
                BeanUtils.populate(sp, req.getParameterMap());

                System.out.println(sp.getMa() + "\n\n\n\n");

                Optional.ofNullable(repository.add(sp)).ifPresentOrElse(o -> {
                    req.getSession().setAttribute("notify", "added product " + o.toString());
                }, () -> {
                    req.getSession().setAttribute("notify", "cannot add product");
                });
                resp.sendRedirect("/product");
                return;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        if (uri.contains("/update")) {
            SanPham sp = new SanPham();
            try {
                ConvertUtils.register(new UUIDFromString(), UUID.class);
                BeanUtils.populate(sp, req.getParameterMap());

                System.out.println(sp.getId() + "\n\n\n\n");

                Optional.ofNullable(repository.update(sp)).ifPresentOrElse(o -> {
                    req.getSession().setAttribute("notify", "updated product " + o.toString());
                }, () -> {
                    req.getSession().setAttribute("notify", "cannot update product");
                });
                resp.sendRedirect("/product");
                return;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
