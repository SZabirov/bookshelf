import com.fujitsu.fs.javalab.bookshelf.service.UsersServiceImpl;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersService;

/**
 * Created by Pc on 30.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        System.out.println(usersService.getAll());
    }
}
