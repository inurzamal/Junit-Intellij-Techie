package com.example.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CommentsServiceTest {

    @Autowired
    CommentsService commentsService;

    @Test
    @DisplayName("Test should pass when comments do not contain swear words")
    void containsSwearWords() throws Exception {
        //setup
        String comments = "Hello";

        //invoke
        boolean actualResult = commentsService.containsSwearWords(comments);

        //verify
        assertFalse(actualResult);
//        assertEquals(false, actualResult);

        //---------------------------OR--------------------------------//
        // invoke & verify
//        assertFalse(commentsService.containsSwearWords(comments));
//        assertThat(commentsService.containsSwearWords(comments)).isFalse(); // using assertj library
    }

    @Test
    @DisplayName("Should Throw Exception when Exception contain swear words")
    void containsSwearWords2(){
        //setup
        String comment = "This is shitty comment";

        //invoke
        Exception exception = assertThrows(Exception.class, () -> {
            commentsService.containsSwearWords(comment);
        });

        //verify
        assertTrue(exception.getMessage().contains("Comments contains unacceptable language"));

        //--------------------OR using assertj library---invoke & verify------------------//
//        assertThatThrownBy(()-> {
//            commentsService.containsSwearWords(comment);
//        }).isInstanceOf(Exception.class).hasMessage("Comments contains unacceptable language");
    }
}