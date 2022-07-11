package com.todolist.repository;


import com.todolist.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<PostsEntity,Integer> {

}
