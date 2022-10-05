package cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "fruits")
public class Fruit {

    @Id
    private String id;

    private String name;

    private int kilos;

    public Fruit() {
    }

    public Fruit(String name, int kilos) {
        this.name = name;
        this.kilos = kilos;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKilos() {
        return kilos;
    }

    public void setKilos(int kilos) {
        this.kilos = kilos;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kilos=" + kilos +
                '}';
    }
}
