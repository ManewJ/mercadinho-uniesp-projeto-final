package com.mercadinho.mercadinho_uniesp.model;

import com.mercadinho.mercadinho_uniesp.validator.TelefoneBR;
import com.mercadinho.mercadinho_uniesp.validator.ValidCPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @TelefoneBR
    private String telefone;

    @Email(message = "Formato de e-mail inválido.")
    @NotBlank(message = "O e-mail não pode estar em branco")
    @Size(min = 255, message = "O e-mail não pode exceder 255 caracteres.")
    private String email;


    @ValidCPF
    @NotBlank(message = "O CPF não pode estar em branco")
    private String cpf;
}