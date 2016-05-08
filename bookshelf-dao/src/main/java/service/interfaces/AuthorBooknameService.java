package service.interfaces;

import model.Author;
import model.AuthorBookname;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public interface AuthorBooknameService {

    List<AuthorBookname> getAll();

    List<AuthorBookname> getAllByAuthor(Author author);

    List<AuthorBookname> getAllByBookname(String bookname);

    List<AuthorBookname> getAllVerifiedBooksForAuthor(Author author);
}
