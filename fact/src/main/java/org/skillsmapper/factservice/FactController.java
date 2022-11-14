package org.skillsmapper.factservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactController {

    private final FactRepository repository;

    FactController(FactRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/facts")
    Iterable<Fact> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/facts")
    Fact newFact(@RequestBody Fact newFact) {
        return repository.save(newFact);
    }

    // Single item

    @GetMapping("/facts/{id}")
    Fact one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new FactNotFoundException(id));
    }

    @PutMapping("/facts/{id}")
    Fact replaceFact(@RequestBody Fact newFact, @PathVariable Long id) {

        return repository.findById(id)
                .map(fact -> {
                    fact.setType(newFact.getType());
                    fact.setSkill(newFact.getSkill());
                    return repository.save(fact);
                })
                .orElseGet(() -> {
                    newFact.setId(id);
                    return repository.save(newFact);
                });
    }

    @DeleteMapping("/facts/{id}")
    void deleteFact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
