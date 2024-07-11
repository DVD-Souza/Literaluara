package Challenger.literalura.repository;

import Challenger.literalura.models.Author;
import Challenger.literalura.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    @Query("SELECT DISTINCT a FROM Books b JOIN b.authors a WHERE YEAR(a.birthYear) <= :year")
List<Author> findByAuthorsBirthYearLessThanEqual(int year);

    @Query("SELECT b.authors FROM Books b")
    List<Author> findAllAuthors();

    @Query("SELECT a FROM Books b JOIN b.authors a WHERE lower(a.name) LIKE lower(concat('%', :name, '%'))")
    List<Author> findByAuthorsName(String name);
}