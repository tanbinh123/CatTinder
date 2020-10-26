package fi.taponen.cattinder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.taponen.cattinder.domain.Cat;
import fi.taponen.cattinder.domain.CatRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // To use MariaDB as test DB
public class CatRepositoryTest {
	
	@Autowired
	private CatRepository repository;
	
	@Test
	public void findByLocationShouldReturnCat() {
		List<Cat> cats = repository.findByLocation("Helsinki");
		assertThat(cats).hasSize(2);
		assertThat(cats.get(0).getName()).isEqualTo("Gizmo");
	}
	
	@Test
	public void whenCreateCatCatIdShouldNotBeNull() {
		Cat cat = new Cat("Milla", "Friendly and fat", "Hyvinkää", true, 1997);
		repository.save(cat);
		assertThat(cat.getId()).isNotNull();
	}
	
	@Test
	public void deleteCatByIdShouldDecreaseRepoSizeByOne() {
		List<Cat> cat = repository.findByName("Angelo");
		Long id = cat.get(0).getId();
		System.out.println("id" + id);
		repository.deleteById(id);
        assertThat(repository.count()).isEqualTo(4);
	}
}
