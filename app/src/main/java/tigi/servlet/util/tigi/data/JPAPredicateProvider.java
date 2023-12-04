package tigi.servlet.util.tigi.data;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;

public interface JPAPredicateProvider {
  Predicate pred(CriteriaBuilder criteriaBuilder);
}
