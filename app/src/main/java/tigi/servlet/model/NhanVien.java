package tigi.servlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class NhanVien {
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

  @Nationalized
  @Column(name = "GioiTinh", length = 10)
  private String gioiTinh;

  @Column(name = "NgaySinh")
  private LocalDate ngaySinh;

  @Nationalized
  @Column(name = "DiaChi", length = 100)
  private String diaChi;

  @Column(name = "Sdt", length = 30)
  private String sdt;

  @Lob
  @Column(name = "MatKhau")
  private String matKhau;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IdCH")
  private CuaHang idCH;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IdCV")
  private ChucVu idCV;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IdGuiBC")
  private NhanVien idGuiBC;

  @Column(name = "TrangThai")
  private Integer trangThai;

}
