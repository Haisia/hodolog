package com.hodolog.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  @Lob
  private String content;

  @Builder
  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }


}














