package tigi.servlet.repository.general;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import tigi.servlet.util.DBC;
import tigi.servlet.util.tigi.data.JPAPredicateProvider;
import tigi.servlet.util.tigi.data.Model;

import java.util.List;
import java.util.Optional;

public abstract class GeneralRepository <T extends Model<Id>, Id> {

  private EntityManager entityManager;

  public abstract Class<T> getClassInfo();

  public GeneralRepository() {
    this.entityManager = DBC.getEntityManager();
  }

  public List<T> getAll() {

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

    CriteriaQuery<T> cq = cb.createQuery(getClassInfo());

    Root<T> root = cq.from(getClassInfo());

    TypedQuery<T> q = entityManager.createQuery(cq);

    return q.getResultList();

  }

  public Id add(T en) {
    EntityTransaction tx = entityManager.getTransaction();
    tx.begin();

    try {
      entityManager.persist(en);
      tx.commit();
      return en.getId();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
      return null;
    }
  }

  public Id update(T en) {
    EntityTransaction tx = entityManager.getTransaction();
    tx.begin();

    try {
      entityManager.merge(en);
      tx.commit();
      return en.getId();
    } catch (Exception e) {
      tx.rollback();
      return null;
    }
  }

  public Id remove(T en) {
    EntityTransaction tx = entityManager.getTransaction();
    tx.begin();

    try {
      entityManager.remove(en);
      tx.commit();
      return en.getId();
    } catch (Exception e) {
      tx.rollback();
      return null;
    }
  }

  public Id removeById(Id id) {
    Optional<T> opt = Optional.ofNullable(this.findById(id));

    EntityTransaction tx = entityManager.getTransaction();

    try {
      if (opt.isPresent()) {
        entityManager.remove(opt.get());

        tx.commit();
        entityManager.flush();
        return opt.get().getId();
      }
      tx.rollback();
      return null;
    } catch (Exception e) {
      tx.rollback();
      return null;
    }
  }

  public T findById(Id id) {
    return entityManager.find(getClassInfo(), id);
  }

  public List<T> findBy(JPAPredicateProvider jpp) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

    CriteriaQuery<T> cq = cb.createQuery(getClassInfo());

    Root<T> root = cq.from(getClassInfo());

    cq.where(jpp.pred(cb));

    TypedQuery<T> q = entityManager.createQuery(cq);

    return q.getResultList();
  }
}
