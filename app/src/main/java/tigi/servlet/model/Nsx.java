package tigi.servlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "NSX")
public class Nsx {
  @Id
  @Column(name = "Id", nullable = false)
  private UUID id;

  @Column(name = "Ma", length = 20)
  private String ma;

  @Nationalized
  @Column(name = "Ten", length = 30)
  private String ten;

}
