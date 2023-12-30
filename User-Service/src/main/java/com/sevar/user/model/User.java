package com.sevar.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_users")
@Builder
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String role;
	private String password;
}
