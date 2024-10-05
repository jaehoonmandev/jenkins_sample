package org.jaehoonman.jenkins_sample.controller;

import org.jaehoonman.jenkins_sample.entity.Users;
import org.jaehoonman.jenkins_sample.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class users {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService){
        this.usersService = usersService;
    }
    // 모든 사용자 조회
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // ID로 사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user = usersService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없음: " + id));
        return ResponseEntity.ok(user);
    }

    // 이름으로 사용자 조회
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Users>> getUserByName(@PathVariable String name) {
        List<Users> users = usersService.findUserByName(name);
        return ResponseEntity.ok(users);
    }

    // 새로운 사용자 생성
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users createdUser = usersService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // 사용자 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users userDetails) {
        Users updatedUser = usersService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // 사용자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
