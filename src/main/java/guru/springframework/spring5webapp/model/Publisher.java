package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    // TODO Make this OneToMany relationship
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Publisher() {
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher(String name, String address, Set<Book> books) {
        this.name = name;
        this.address = address;
        this.books = books;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getId(), publisher.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publisher{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
