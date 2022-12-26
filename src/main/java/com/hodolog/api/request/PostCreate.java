package com.hodolog.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class PostCreate {

  @NotBlank(message = "타이틀을 입력해주세요.")
  private String title;

  @NotBlank(message = "컨텐츠를 입력해주세요")
  private String content;

  @Builder
  public PostCreate(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
