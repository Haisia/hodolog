package com.hodolog.api.service;

import com.hodolog.api.domain.Post;
import com.hodolog.api.repository.PostRepository;
import com.hodolog.api.request.PostCreate;
import com.hodolog.api.response.PostResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

  @Autowired
  private PostService postService;

  @Autowired
  private PostRepository postRepository;

  @BeforeEach
  void clean(){
    postRepository.deleteAll();
  }


  @Test
  @DisplayName("글 작성")
  public void test1() throws Exception {
    //given
    PostCreate postCreate = PostCreate.builder()
            .title("제목입니다.")
            .content("내용입니다.")
            .build();

    //when
    postService.write(postCreate);

    //then
    assertEquals(1L, postRepository.count());
    Post post = postRepository.findAll().get(0);
    assertEquals("제목입니다.", post.getTitle());
    assertEquals("내용입니다.", post.getContent());
  }


  @Test
  @DisplayName("글 1개 조회")
  void test2(){
    // given
    Post requestPost = Post.builder()
            .title("foo")
            .content("bar")
            .build();
    postRepository.save(requestPost);

    // when
    PostResponse response = postService.get(requestPost.getId());

    // then
    assertNotNull(response);
    assertEquals(1L, postRepository.count());
    assertEquals("foo", response.getTitle());
    assertEquals("bar", response.getContent());
  }


}



























