package com.todolist.repository;

import com.todolist.entity.PostsEntity;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void clanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 글_불러오기(){
        //given
        String content = "테스트";

        postsRepository.save(PostsEntity
                .builder()
                        .content(content)
                .build());
        //when
        List<PostsEntity> postsList = postsRepository.findAll();

        //then
        PostsEntity postsEntity = postsList.get(0);
        assertThat(postsEntity.getContent()).isEqualTo(content);

    }




}