package org.example.devoir;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String ref;

  @Column(name = "cpt_deb")
  private String cptDeb;

  @Column(name = "cpt_cred")
  private String cptCred;

  private double montant;

  private String date;

  private String type;

  public Transaction() {
  }

  public Transaction(String ref, String cptDeb, String cptCred, double montant) {
    this.ref = ref;
    this.cptDeb = cptDeb;
    this.cptCred = cptCred;
    this.montant = montant;
    this.type = (cptCred.substring(0, 3).equals(cptDeb.substring(0, 3))) ? "VIRINT" : "VIRCHAR";
    this.date = Transaction.date();
  }

  public static String date() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    return formatter.format(date);
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getCptDeb() {
    return cptDeb;
  }

  public void setCptDeb(String cptDeb) {
    this.cptDeb = cptDeb;
  }

  public String getCptCred() {
    return cptCred;
  }

  public void setCptCred(String cptCred) {
    this.cptCred = cptCred;
  }

  public double getMontant() {
    return montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
