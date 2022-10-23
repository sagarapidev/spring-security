package com.basic.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "user")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3331463614215600415L;
	@Id
    //@EqualsAndHashCode.Include
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id",columnDefinition = "VARCHAR(255)")
    private String Id;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String first_name;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String last_name;
         @NonNull
         private String login;
         @NonNull
         @EqualsAndHashCode.Include
         private String email;
         @JsonIgnoreProperties(ignoreUnknown = true)
         @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
         private String   password_hash;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String   image_url ;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private boolean  activated;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String   lang_key;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String   activation_key;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String   reset_key;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String   created_by;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private String   last_modified_by;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private Instant  created_date;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private Instant  reset_date ;
         @JsonIgnoreProperties(ignoreUnknown = true)
         private Instant  last_modified_date;
         
     	@ManyToMany(fetch=FetchType.EAGER)
    	@JoinTable(name="user_role",
    			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    	private Set<Role> roles=new HashSet<Role>();

}
