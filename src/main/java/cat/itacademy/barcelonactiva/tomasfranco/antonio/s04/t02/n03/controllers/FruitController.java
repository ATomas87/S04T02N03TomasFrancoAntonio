package cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.tomasfranco.antonio.s04.t02.n03.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    FruitService fruitService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            List<Fruit> fruits = new ArrayList<>(fruitService.getAllFruits());

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") String id) {
        Optional<Fruit> fruit = fruitService.getFruitById(id);

        if (fruit.isPresent()) {
            return new ResponseEntity<>(fruit.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = fruitService.addFruit(fruit);
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") String id, @RequestBody Fruit fruit) {
        Optional<Fruit> fruitToUpdate = fruitService.getFruitById(id);

        if (fruitToUpdate.isPresent()) {
            Fruit _fruit = fruitToUpdate.get();
            _fruit.setName(fruit.getName());
            _fruit.setKilos(fruit.getKilos());
            return new ResponseEntity<>(fruitService.updateFruit(_fruit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") String id) {
        try {
            fruitService.deleteFruit(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
