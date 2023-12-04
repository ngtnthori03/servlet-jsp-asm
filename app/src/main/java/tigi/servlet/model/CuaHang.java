package tigi.servlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import tigi.servlet.util.tigi.data.Model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class CuaHang implements Model<UUID> {
  @Id
  @Column(name = "Id", nullable = false)
  private UUID id;

  @Column(name = "Ma", length = 20)
  private String ma;

  @Nationalized
  @Column(name = "Ten", length = 50)
  private String ten;

  @Nationalized
  @Column(name = "DiaChi", length = 100)
  private String diaChi;

  @Nationalized
  @Column(name = "ThanhPho", length = 50)
  private String thanhPho;

  @Nationalized
  @Column(name = "QuocGia", length = 50)
  private String quocGia;

  @OneToMany(mappedBy = "idCH")
  private Set<NhanVien> nhanViens = new LinkedHashSet<>();

}
