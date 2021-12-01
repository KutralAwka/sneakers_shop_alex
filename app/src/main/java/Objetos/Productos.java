package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Productos {

    private int id;
    private String[] productos = {"Air Force One","Jordan Retro 3", "Jordan Retro 1", "Ozweego"};
    private int[] precios = {60000, 120000, 100000, 89990};
    private int stock;

    public Productos()
    {}

    public Productos(int id, String[] productos, int[] precios, int stock) {
        this.id = id;
        this.productos = productos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getProductos() {
        return productos;
    }

    public void setProductos(String[] productos) {
        this.productos = productos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos1 = (Productos) o;
        return id == productos1.id && stock == productos1.stock && Arrays.equals(productos, productos1.productos) && Arrays.equals(precios, productos1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(productos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", productos=" + Arrays.toString(productos) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }


    //regla de Negocio

    public int anadirAdicional(int valor, int adicional)
    {
        return valor + adicional;
    }

}
