package br.com.convergencia.testejavar1.entity.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	
	private String cpf;
	private String password;

}
