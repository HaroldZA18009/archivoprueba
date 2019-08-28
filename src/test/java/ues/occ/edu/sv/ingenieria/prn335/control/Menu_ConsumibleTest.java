/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.cinedatalib.entities.MenuConsumible;

@ExtendWith(MockitoExtension.class)
public class Menu_ConsumibleTest {
    long precio=10;
    public Menu_ConsumibleTest() {
        
    }
    @Test
    public void crearTest() throws Exception{
        System.out.println("Crear");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        
        Menu_Consumible menuc = new Menu_Consumible();
        menuc.em=mockEM;
        MenuConsumible r = new MenuConsumible();
        
        r.setIdConsumible(1);
        r.setNombre("producto");
        r.setPrecio(precio);
        menuc.crear(r);
        Mockito.verify(mockEM, Mockito.times(1)).persist(Mockito.any());
    }
    @Test
    public void eliminarTest() throws Exception{
        System.out.println("Eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        
        Menu_Consumible menuc = new Menu_Consumible();
        menuc.em=mockEM;
        MenuConsumible r = new MenuConsumible();
        
        r.setIdConsumible(1);
        r.setNombre("Nombre del producto");
        r.setPrecio(precio);
        menuc.crear(r);
        Mockito.verify(mockEM, Mockito.times(1)).persist(Mockito.any());
    }
   
    @Test
    public void consumibleFormatoTest() throws Exception{
        System.out.println("ConsumibleFormato");
        Menu_Consumible menuc = new Menu_Consumible();
        String producto = "H-Sundae";
        String result = menuc.consumibleFormato(producto);
    }
   
    
}
