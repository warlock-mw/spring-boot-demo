package com.springbootdemo.domain;

import java.util.List;
import com.springbootdemo.dto.UserDto;
import lombok.Data;

@Data
public class UserDomain {

  private List<UserDto> userList;

}
