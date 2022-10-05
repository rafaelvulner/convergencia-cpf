package br.com.convergencia.testejavar1.entity;

import br.com.convergencia.testejavar1.entity.enums.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cpf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
