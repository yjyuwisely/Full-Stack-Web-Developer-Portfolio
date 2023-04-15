package  com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.example.demo.model.User;

//Member 엔티티를 데이터베이스에 저장할 수 있도록 MemberRepository를 만든다.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//회원 가입 시 중복된 회원이 있는지 검사하기 위해서 이메일로 회원을 검사할 수 있도록 쿼리 메서드를 작성한다.
	User findByEmail(String email);
}