package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * @author BBVA Test
 * Book data bean
 */
@Entity
@Cache
@ApiModel("Book object")
public class BookBean {

    @Id
    private Long id;

    private String name;
    
    private Integer yearPub;
    
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearPub() {
		return yearPub;
	}

	public void setYearPub(Integer yearPub) {
		this.yearPub = yearPub;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
    
    
}
