/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Crisl
 */
@Entity
@Table(name = "post")
public class Post implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_post", sequenceName = "seq_post_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_post", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O titulo não pode ser nulo")
    @NotBlank(message = "O titulo não pode ser em branco")
    @Length(max = 50, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "title", length = 50, nullable = false)    
    private String title;
    
    @NotNull(message = "O conteúdo não pode ser nulo")
    @NotBlank(message = "O conteúdo não pode ser em branco")
    @Length(max = 255, message = "O conteúdo não pode ter mais que {max} caracteres")
    @Column(name = "content", length = 50, nullable = false)    
    private String content;
    
    @NotNull(message = "A pessoa não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_post_person"))
    private Person person;
    
    public Post(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
