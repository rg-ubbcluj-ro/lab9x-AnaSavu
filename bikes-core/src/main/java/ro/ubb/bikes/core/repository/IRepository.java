package ro.ubb.bikes.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.ubb.bikes.core.model.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface IRepository<T extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<T, ID> {
}
