package tigi.servlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import tigi.servlet.util.tigi.data.Model;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class ChiTietSP implements Model<UUID> {
  @Id
  @Column(name = "Id", nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IdSP")
  private SanPham idSP;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IdNsx")
  private Nsx idNsx;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IdMauSac")
  private MauSac idMauSac;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IdDongSP")
  private DongSP idDongSP;

  @Column(name = "NamBH")
  private Integer namBH;

  @Nationalized
  @Column(name = "MoTa", length = 50)
  private String moTa;

  @Column(name = "SoLuongTon")
  private Integer soLuongTon;

  @Column(name = "GiaNhap", precision = 20)
  private BigDecimal giaNhap;

  @Column(name = "GiaBan", precision = 20)
  private BigDecimal giaBan;

}
