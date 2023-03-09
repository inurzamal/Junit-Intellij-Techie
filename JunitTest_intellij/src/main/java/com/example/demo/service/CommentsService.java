package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    public boolean containsSwearWords(String comment) throws Exception {
        if (comment.contains("shitty")) {
            throw new Exception("Comments contains unacceptable language");
        }
        return false;
    }

}
