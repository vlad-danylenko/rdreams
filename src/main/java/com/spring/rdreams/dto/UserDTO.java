package com.spring.rdreams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String email;
    @JsonProperty("roleList")
    private List<RoleDTO> roleList;
}
