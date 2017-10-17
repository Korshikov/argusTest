package ru.delfserver.argusTest.entity;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "nodes")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Node {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "region")
  private String region;

  @Column(name = "street")
  private String street;

  @Column(name = "house")
  private String house;

  @OneToMany(cascade = {CascadeType.REMOVE},fetch = FetchType.EAGER)
  private Set<ConnectionUnit> connectionUnits;


  public Node(String name, String region, String street, String house) {
    this.name = name;
    this.region = region;
    this.street = street;
    this.house = house;
  }

  public Node() {
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

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getHouse() {
    return house;
  }

  public void setHouse(String house) {
    this.house = house;
  }

  public Set<ConnectionUnit> getConnectionUnits() {
    return connectionUnits;
  }
}
