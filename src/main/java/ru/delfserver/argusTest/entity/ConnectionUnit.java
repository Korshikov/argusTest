package ru.delfserver.argusTest.entity;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "connection_units")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ConnectionUnit {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "capacity", nullable = false)
  @PositiveOrZero
  private Long capacity;

  @ManyToOne(cascade = {CascadeType.REMOVE})
  @JoinColumn(name = "node_id", nullable = false)
  private Node parentNode;

  @OneToMany
  private Set<Point> points;

  public ConnectionUnit(String name, Long capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCapacity() {
    return capacity;
  }

  public Set<Point> getPoints() {
    return points;
  }
}
