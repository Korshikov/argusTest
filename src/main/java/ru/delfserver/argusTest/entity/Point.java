package ru.delfserver.argusTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import ru.delfserver.argusTest.annotation.ForbidJoinYourself;
import ru.delfserver.argusTest.annotation.PointPositionLessThanCUCapacity;

@Entity
@Table(name = "points", uniqueConstraints =
    {@UniqueConstraint(columnNames = {"connection_unit_id", "position"})}
)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@PointPositionLessThanCUCapacity
@ForbidJoinYourself
public class Point {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "connection_unit_id", nullable = false)
  private ConnectionUnit parentConnectionUnit;

  @Column(name = "position", nullable = false)
  @PositiveOrZero
  private Long position;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "linked_point_id")

  private Point linkedPoint;

  public Point(ConnectionUnit parentConnectionUnit, Long position) {
    this.parentConnectionUnit = parentConnectionUnit;
    this.position = position;
  }

  public Point(ConnectionUnit parentConnectionUnit, Long position,
      Point linkedPoint) {
    this.parentConnectionUnit = parentConnectionUnit;
    this.position = position;
    this.linkedPoint = linkedPoint;
  }

  public Long getId() {
    return id;
  }

  public ConnectionUnit getParentConnectionUnit() {
    return parentConnectionUnit;
  }

  public Long getPosition() {
    return position;
  }

  public Point getLinkedPoint() {
    return linkedPoint;
  }

  public void setLinkedPoint(Point linkedPoint) {
    this.linkedPoint = linkedPoint;
  }
}
