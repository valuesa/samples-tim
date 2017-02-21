package cn.boxfish.db.sample1.jpa;

import cn.boxfish.db.sample1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by LuoLiBing on 17/2/21.
 */
public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query(value = "delete from Person p where p.age=?1")
    void deleteByAge(Integer age);
}
