package org.jaehoonman.jenkins_sample.service;

import org.jaehoonman.jenkins_sample.entity.Users;
import org.jaehoonman.jenkins_sample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    // 모든 사용자 조회
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    // 아이디로 사용자 조회
    public Optional<Users> findUserById(Long id){
        return usersRepository.findById(id);
    }

    // 이름으로 사용자 조회
    public List<Users> findUserByName(String name) {
        return usersRepository.findByName(name);
    }

    // 사용자 생성
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    // 사용자 업데이트
    public Users updateUser(Long id, Users userDetails) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없음: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return usersRepository.save(user);
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없음: " + id));
        usersRepository.deleteById(id);
    }

}
