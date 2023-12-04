package tigi.servlet.util;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import tigi.servlet.model.SanPham;

import java.util.Properties;

public class DBC {

  @Getter
  private static final SessionFactory FACTORY;

  static {
    Configuration conf = new Configuration();

    Properties properties = new Properties();
    properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
    properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
    properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;trustServerCertificate=true");
    properties.put(Environment.USER, "sa");
    properties.put(Environment.PASS, "r00t:R00T");
    properties.put(Environment.SHOW_SQL, "true");
    properties.put(Environment.FORMAT_SQL, "true");

    conf.setProperties(properties);

    // add annotated classes

    conf.addAnnotatedClass(SanPham.class)
    ;

    ServiceRegistry registry = new StandardServiceRegistryBuilder()
      .applySettings(conf.getProperties()).build();
    FACTORY = conf.buildSessionFactory(registry);

    System.out.println((FACTORY == null) + "\n\n\n");

  }

  public static EntityManager getEntityManager() {
    return FACTORY.createEntityManager();
  }

  public static void main(String[] args) {
    System.out.println(getFACTORY());
  }
}
