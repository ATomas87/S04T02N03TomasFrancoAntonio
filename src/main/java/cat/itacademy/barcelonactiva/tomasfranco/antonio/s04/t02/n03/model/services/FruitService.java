package cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {
    @Autowired
    Repository repository;

    public List<Fruit> getAllFruits() {
        return repository.findAll();
    }

    public Fruit addFruit(Fruit fruit) {
        return repository.save(new Fruit(fruit.getName(), fruit.getKilos()));
    }

    public Fruit updateFruit(Fruit fruit) {
        return repository.save(fruit);
    }

    public Optional<Fruit> getFruitById(String id) {
        return repository.findById(id);
    }

    public void deleteFruit(String id) {
        repository.deleteById(id);
    }
}
