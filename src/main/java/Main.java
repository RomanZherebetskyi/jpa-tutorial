import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        User user = new User();
//        user.setName("Taras");
//        user.setAge(31);

//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        User user1 = entityManager.find(User.class, 1);
//        System.out.println(user1);
//        user1.setName("Petro");
//        entityManager.merge(user1);
//        entityManager.getTransaction().commit();

//        entityManager.getTransaction().begin();
//        entityManager.remove(user1);
//        entityManager.getTransaction().commit();

//        List resultList = entityManager.createQuery("select u from User u where u.name like :name")
//                .setParameter("name", "Borys")
//                .getResultList();
//        System.out.println(resultList);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        ParameterExpression<String> parameterExpression = criteriaBuilder.parameter(String.class, "name");
        query.select(from).where(criteriaBuilder.like(from.get("name"), parameterExpression));
        List<User> resultList = entityManager.createQuery(query).setParameter("name", "Borys").getResultList();
        System.out.println(resultList);

        entityManager.close();
        entityManagerFactory.close();
    }
}
