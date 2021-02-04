package uz.doniyorbek7376.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import uz.doniyorbek7376.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
