/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo4.ciclo4.Repositorio;

import ciclo4.ciclo4.Interface.interfaceOrder;
import ciclo4.ciclo4.Modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author calix
 */
@Repository
public class OrderRepositorio {

    @Autowired
    private interfaceOrder crud;

    public List<Order> getAll() {
        return (List<Order>) crud.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return crud.findById(id);
    }

    public Order save(Order order) {
        return crud.save(order);
    }

    public void delete(Order order) {
        crud.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return crud.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return crud.findByZone(zona);
    }
    public List<Order> SalesMan(int id) {
        return crud.findSalesManById(id); 
    }

    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return crud.findSalesManByDate(dateStr,id); 
    }

    public List<Order> ordersSalesManByState(String state, Integer id) {
        return crud.findSalesManByState(state,id);
    }
    
}

