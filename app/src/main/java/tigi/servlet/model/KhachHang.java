package tigi.servlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class KhachHang {
  @Id
  @Column(name = "Id", nullable = false)
  private UUID id;

  @Column(name = "Ma", length = 20)
  private String ma;

  @Nationalized
  @Column(name = "Ten", length = 30)
  private String ten;

  @Nationalized
  @Column(name = "TenDem", length = 30)
  private String tenDem;

  @Nationalized
  @Column(name = "Ho", length = 30)
  private String ho;

  @Column(name = "NgaySinh")
  private LocalDate ngaySinh;

  @Column(name = "Sdt", length = 30)
  private String sdt;

  @Nationalized
  @Column(name = "DiaChi", length = 100)
  private String diaChi;

  @Nationalized
  @Column(name = "ThanhPho", length = 50)
  private String thanhPho;

  @Nationalized
  @Column(name = "QuocGia", length = 50)
  private String quocGia;

  @Lob
  @Column(name = "MatKhau")
  private String matKhau;

}
