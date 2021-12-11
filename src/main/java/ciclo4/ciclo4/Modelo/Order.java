/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo4.ciclo4.Modelo;

import java.util.Date;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author calix
 */
@Document(collection = "orders")
public class Order {

    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";

    @Id
    private Integer id;
    private Date RegisterDay;
    private String status;
    private User salesMan;

    private Map<String, clothe> products;
    private Map<String, Integer> quantites;

    public Order() {
    }

    public Order(Integer id, Date RegisterDay, String status, User salesMan, Map<String, clothe> products, Map<String, Integer> quantites) {
        this.id = id;
        this.RegisterDay = RegisterDay;
        this.status = status;
        this.salesMan = salesMan;
        this.products = products;
        this.quantites = quantites;
    }

    public static String getPENDING() {
        return PENDING;
    }

    public static void setPENDING(String PENDING) {
        Order.PENDING = PENDING;
    }

    public static String getAPROVED() {
        return APROVED;
    }

    public static void setAPROVED(String APROVED) {
        Order.APROVED = APROVED;
    }

    public static String getREJECTED() {
        return REJECTED;
    }

    public static void setREJECTED(String REJECTED) {
        Order.REJECTED = REJECTED;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDay() {
        return RegisterDay;
    }

    public void setRegisterDay(Date RegisterDay) {
        this.RegisterDay = RegisterDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(User salesMan) {
        this.salesMan = salesMan;
    }

    public Map<String, clothe> getProducts() {
        return products;
    }

    public void setProducts(Map<String, clothe> products) {
        this.products = products;
    }

    public Map<String, Integer> getQuantites() {
        return quantites;
    }

    public void setQuantites(Map<String, Integer> quantites) {
        this.quantites = quantites;
    }

    
}
