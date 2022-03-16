package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@Schema(name = "author")
public class Author {
  @Parameter(name = "first_name")
  private String firstName;
  @Parameter(name = "last_name")
  private String lastName;
  @Parameter(name = "age")
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
