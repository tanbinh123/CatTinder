package fi.taponen.cattinder.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CatRepository extends CrudRepository<Cat, Long> {
	List<Cat> findByLocation(@Param("location") String location);
}
