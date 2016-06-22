package cn.boxfish.mall.entity.jpa;

import cn.boxfish.mall.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by LuoLiBing on 16/3/17.
 */
public interface TeacherJpaRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "select t from Teacher t,TeacherHasRole r where t.id=r.teacherId and r.roleId=?1")
    Page<Teacher> findTeacher1(Pageable pageable, Long roleId);

    List<Teacher> findByName(String name);
}
