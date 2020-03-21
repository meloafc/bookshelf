package com.meloafc.bookshelf.service;

import com.meloafc.bookshelf.exception.InvalidEntityException;
import com.meloafc.bookshelf.model.BaseModel;
import com.meloafc.bookshelf.utils.ValidateUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.UnexpectedRollbackException;

import java.io.Serializable;
import java.util.List;

public abstract class GenericService<T extends BaseModel, I extends Serializable> {
    @Autowired
    protected JpaRepository<T, I> repository;

    public T saveOrUpdate(T entity) {
        try {
            return repository.save(entity);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityException(e.getMessage());
        }
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T get(I id) {
        T entity = repository.findById(id).orElse(null);
        ValidateUtils.checkFound(entity, "object.not.found");
        return entity;
    }

    public T add(T entity) {
        validateId(entity, false);
        validate(entity);
        return this.saveOrUpdate(entity);
    }

    public T update(T entity) {
        validateId(entity, true);
        validate(entity);
        return this.saveOrUpdate(entity);
    }

    public void remove(T entity) {
        try {
            repository.delete(entity);
        } catch (ConstraintViolationException | DataIntegrityViolationException | UnexpectedRollbackException e) {
            throw new InvalidEntityException("constraintViolationOnDelete");
        }
    }

    public void removeById(I id) {
        try {
            repository.deleteById(id);
        } catch (ConstraintViolationException | DataIntegrityViolationException | UnexpectedRollbackException e) {
            throw new InvalidEntityException("constraintViolationOnDelete");
        }
    }

    public void validate(T entity) {
        validateUniqueKey(entity);
    }

    public void validateUniqueKey(T entity) {
    }

    public void validateId(T entity, boolean isUpdate) {
        if (isUpdate) {
            ValidateUtils.checkBiggerThanZero((Long) entity.getId(), "id.mustBeFilled");
        } else {
            ValidateUtils.checkMustBeNullOrZero((Long) entity.getId(), "id.cannotBeFilled");
        }
    }

}
