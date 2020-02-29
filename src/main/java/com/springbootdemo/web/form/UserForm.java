package com.springbootdemo.web.form;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserForm {

  @NotBlank(message = "ユーザー名を入力してください")
  private String name;

  @NotBlank(message = "メールアドレスを入力してください")
  private String email;

  @NotBlank(message = "パスワードを入力してください")
  private String password;
}
