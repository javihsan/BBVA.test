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

	public enum Genre { EPICA, CUENTO, NOVELA, TRAGEDIA, COMEDIA, CRONICA, BIOGRAFIA, FABULA, ENSAYO, ROMANCE}
	
    @Id
    private Long id;

    private String name;
    
    private String author;
    
    private Integer yearPub;
    
    private Genre genre;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYearPub() {
		return yearPub;
	}

	public void setYearPub(Integer yearPub) {
		this.yearPub = yearPub;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
    
    
}
