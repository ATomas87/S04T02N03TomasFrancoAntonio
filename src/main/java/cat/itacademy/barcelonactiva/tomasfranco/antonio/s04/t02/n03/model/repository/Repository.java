package cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Fruit, String> {
}
