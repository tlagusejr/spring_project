package com.todolist.contorller;

import com.todolist.entity.PostsEntity;
import com.todolist.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;


@Controller
public class controller {

    @Autowired
    PostsRepository postsRepository;

    @GetMapping("index")
    public String index(Model model){
        List<PostsEntity> tableList = postsRepository.findAll();
        model.addAttribute("tableList" ,tableList);

        return "index";


    }
    @GetMapping("/submit")
    public String data(@RequestParam("content") String content, Model model){
        postsRepository.save(PostsEntity
                .builder()
                .content(content)
                .build());
        return "redirect:/index";



    }
    @GetMapping("/deleteall")
    public String deleteall() {
        postsRepository.deleteAll();
        return "redirect:/index";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("idx") Integer idx) {
        postsRepository.deleteById(idx);
        return "redirect:/index";
    }
}
