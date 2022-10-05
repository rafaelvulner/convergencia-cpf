package br.com.convergencia.testejavar1.entity.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
	
	private String type;
	private String token;

}
