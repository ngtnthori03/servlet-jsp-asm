package tigi.servlet.repository;

import tigi.servlet.model.SanPham;
import tigi.servlet.repository.general.GeneralRepository;

import java.util.UUID;

public class ProductRepository extends GeneralRepository<SanPham, UUID> {

  @Override
  public Class<SanPham> getClassInfo() {
    return SanPham.class;
  }

  public ProductRepository() {
    super();
  }
}
