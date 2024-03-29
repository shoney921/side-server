package com.example.demo_mall.mallapi.repository;

import com.example.demo_mall.mallapi.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @EntityGraph(attributePaths = {"memberRoleList"})
    @Query("select m from Member m where m.id = :id")
    Member getWithRoles(@Param("id") Long id);

    boolean existsByNickname(String nickname);
}
