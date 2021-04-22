package ro.ubb.bikes.core.service.interfaces;

import ro.ubb.bikes.core.model.BaseEntity;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.io.Serializable;
import java.util.List;

public interface ServiceCommon<ID extends Serializable, T extends BaseEntity<ID>> {

    T add(T entity) throws ValidatorException;

    T delete(ID id) throws ValidatorException;

    T update(T entity) throws ValidatorException;

    List<T> getAll();

    T exist(ID id) throws ValidatorException;
}
