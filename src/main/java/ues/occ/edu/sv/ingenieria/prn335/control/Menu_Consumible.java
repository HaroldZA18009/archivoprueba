package ues.occ.edu.sv.ingenieria.prn335.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.ingenieria.prn335.cinedatalib.entities.MenuConsumible;

public class Menu_Consumible {

    protected EntityManager em;
    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("cinePU");

    public void iniciarEm() {
        this.em = EMF.createEntityManager();
    }

    public EntityTransaction getTx() {
        if (this.em != null) {
            return this.em.getTransaction();
        }
        return null;
    }

    //Metodo para agregar a la base
    public void crear(MenuConsumible r) {
        EntityTransaction tx = this.getTx();
        tx.begin();
        this.em.persist(r);
        tx.commit();
    }

    //Metodo para eliminar en la base
    public void eliminar() {
        MenuConsumible menuC = new MenuConsumible();
        EntityTransaction tx = this.getTx();
        tx.begin();
        em.remove(em.find(MenuConsumible.class, menuC.getIdConsumible()));
        tx.commit();
    }

    public String consumibleFormato(String producto) {
        if (producto == null || producto.isEmpty()){
        return null;
        }else{
        producto = producto.substring(0, 1) + "_" + producto.substring(2, 3).toUpperCase() + producto.substring(3, producto.length());
        return producto;
        }
    }

}
