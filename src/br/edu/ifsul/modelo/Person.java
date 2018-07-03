package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_person", sequenceName = "seq_person_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "name", length = 50, nullable = false)    
    private String name;
    
    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)    
    private String email;
    
    @NotNull(message = "O nome de usuário não pode ser nulo")
    @NotBlank(message = "O nome de usuário não pode ser em branco")
    @Length(max = 20, message = "O nome de usuário não pode ter mais que {max} caracteres")        
    @Column(name = "person", length = 20, nullable = false, unique = true)
    private String person;
    
    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")    
    @Column(name = "password", length = 20, nullable = false) 
    private String password;
    
    @ManyToMany
    @JoinTable(name = "permissions",
            joinColumns
            = @JoinColumn(name = "person", referencedColumnName = "person", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "permission", referencedColumnName = "name", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_permissions",
                        columnNames = {"person", "permission"})})
    private List<Permission> permissions = new ArrayList<>();        

    public Person(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getPessoa() {
        return person;
    }

    public void setPessoa(String person) {
        this.person = person;
    }
    
    
}
