package com.hodolog.api.controller;

import com.hodolog.api.domain.Post;
import com.hodolog.api.request.PostCreate;
import com.hodolog.api.response.PostResponse;
import com.hodolog.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  @PostMapping("/posts")
  public void post(@RequestBody @Valid PostCreate request){
    postService.write(request);
  }

  @GetMapping("/posts/{postId}")
  public PostResponse get(@PathVariable(name = "postId") Long id) {
    PostResponse response = postService.get(id);
    return response;
  }
}
