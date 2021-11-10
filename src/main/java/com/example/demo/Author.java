package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Author {
  private String firstName;
  private String lastName;
  private int age;

  @Hidden
  @JsonProperty(value = "fn")
  public String getFirstName() {
    return firstName;
  }

  @JsonProperty(value = "firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  @Hidden
  @JsonProperty(value = "ln")
  public String getLastName() {
    return lastName;
  }

  @JsonProperty(value = "lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
