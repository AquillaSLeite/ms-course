package leite.aquilla.hroauth.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();
}
