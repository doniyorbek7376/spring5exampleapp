package uz.doniyorbek7376.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import uz.doniyorbek7376.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
