package com.basic.domain;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

/**
 * An authority (a security role) used by Spring Security.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "role")
public class Role{

	private static final long serialVersionUID = 7565176670311275277L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id",columnDefinition = "VARCHAR(255)")
    private String id;

	@JsonIgnoreProperties(ignoreUnknown = true)
    private String name;
    
    @JsonIgnore
	@ManyToMany(mappedBy = "roles",fetch=FetchType.EAGER)
	private Set<User> users=new HashSet<User>();

}
