package com.basic.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name= "log")
public class Log implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
	  private Long event_id;
    
	  @Nullable
	 	private String level;
	 @Temporal(TemporalType.TIMESTAMP)
	 	private Date event_date; 

	 @Column(columnDefinition = "TEXT")
	 	private String throwable; 
	 

	 @Column(columnDefinition = "TEXT")
	 	private String message; 

	 @Column(columnDefinition = "TEXT")
	 	private String logger;

}
