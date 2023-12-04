package tigi.servlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import tigi.servlet.util.tigi.data.Model;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class SanPham implements Model<UUID> {
  @Id
  @Column(name = "Id", nullable = false)
  @GeneratedValue
  private UUID id;

  @Column(name = "Ma", length = 20)
  private String ma;

  @Nationalized
  @Column(name = "Ten", length = 30)
  private String ten;

}
