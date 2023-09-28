package com.spring.rdreams.dto;

import lombok.*;


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
}
