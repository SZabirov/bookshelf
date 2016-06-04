package com.fujitsu.fs.javalab.bookshelf.web.controller;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientHaving;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.*;
import com.fujitsu.fs.javalab.bookshelf.web.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    ClientService clientService;

    @Autowired
    SearchService searchService;

    @Autowired
    BookService bookService;

    @Autowired
    ClientWishService clientWishService;

    @Autowired
    ClientHavingService clientHavingService;

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hiPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            model.addAttribute("login", name);
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model,
                               @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            return "redirect:/profile";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model,
                                 @RequestParam(value = "id", required = false) Integer id) {
        Client client;
        List<ClientHaving> clientHavings;
        List<ClientWish> clientWishes;
        if (id == null) {
            System.out.println("Null id");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            client = clientService.getClientByNickname(name);
        }
        else {
            System.out.println("Not null id");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            if (clientService.getClientByNickname(name).getId() != id) {
                System.out.println("NOT CURRENT");
                client = clientService.getClientById(id);
                model.addAttribute("notCurrent", "notCurrent");
            }
            else {
                client = clientService.getClientByNickname(name);
            }
        }
        clientHavings = client.getClientHavings();
        clientWishes = client.getClientWishes();
        model.addAttribute("havings", clientHavings);
        model.addAttribute("wishes", clientWishes);
        model.addAttribute("client", client);
        return "profile";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model,
                               @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            return "redirect:/profile";
        } else {
            return "registration";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(ModelMap model,
                                   @RequestParam(value = "client", required = false) String clientname,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "surname", required = false) String surname,
                                   @RequestParam(value = "city", required = false) String city,
                                   @RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "password1", required = false) String password1,
                                   @RequestParam(value = "password2", required = false) String password2) {

        if (clientService.ifNicknameExists(clientname)) {
            model.addAttribute("error", "Пользователь с таким логином уже существует");
            return "registration";
        }
        if (clientService.ifEmailExists(email)) {
            model.addAttribute("error", "Пользователь с таким email уже существует");
            return "registration";
        }
        if (!ClientController.checkWithRegExp(email, "email")) {
            model.addAttribute("error", "Неправильный email: " + email);
            return "registration";
        }
        if (!ClientController.checkWithRegExp(clientname, "login")) {
            model.addAttribute("error", "Login " + clientname + " is incorrect");
            return "registration";
        }
        if (!ClientController.checkWithRegExp(name, "name")) {
            model.addAttribute("error", "Неправильное имя: " + name);
            return "registration";
        }
        if (!ClientController.checkWithRegExp(surname, "name")) {
            model.addAttribute("error", "Неправильная фамилия: " + surname);
            return "registration";
        }
        if (!ClientController.checkWithRegExp(city, "name")) {
            model.addAttribute("error", "Неправильный город: " + city);
            return "registration";
        }
        if (!ClientController.checkWithRegExp(phone, "phone")) {
            model.addAttribute("error", "Неправильный номер " + phone);
            return "registration";
        }
        if (!ClientController.checkWithRegExp(password1, "pass")) {
            model.addAttribute("error", "Неправильный формат пароля: " + password1);
            return "registration";
        }
        if (password1.equals(password2)) {
                password1 = HashUtils.md5Apache(password1);

                clientService.addNewClient(clientname, email, name, surname, city, phone, password1, null);
                Set<GrantedAuthority> roles = new HashSet();
                roles.add(new SimpleGrantedAuthority("USER"));
                UserDetails clientDetails = new org.springframework.security.core.userdetails.User(clientname, password1, roles);
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(clientDetails, null, clientDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(token);
            }

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String login = auth.getName();
            Client client = clientService.getClientByNickname(login);
            model.addAttribute("client", client);
            return "profile";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        return "search";
    }

    @RequestMapping(value = "/search_results", method = RequestMethod.GET)
    public String getSearchResults(Model model,
                                   @RequestParam(value = "author_name", required = false) String authorName,
                                   @RequestParam(value = "author_surname", required = false) String authorSurname,
                                   @RequestParam(value = "bookname", required = false) String bookname) {
        List<Book> bookList = searchService.getSearchResult(authorName, authorSurname, bookname);
        model.addAttribute("bookList", bookList);
        return "search_results";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getBook(Model model,
                          @RequestParam(value = "id", required = false) int id) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        List<Client> client = clientHavingService.getAllClientForBook(book);
        model.addAttribute("owners", client);
        return "book";
    }

    @RequestMapping(value = "/addwishing", method = RequestMethod.GET)
    public String addWishing(Model model) {
        return "addwishing";
    }

    @RequestMapping(value = "/postwishing", method = RequestMethod.POST)
    public String postWishing(Model model,
                              @RequestParam(value = "author_name", required = false) String authorName,
                              @RequestParam(value = "author_surname", required = false) String authorSurname,
                              @RequestParam(value = "author_middlename", required = false) String authorMiddlename,
                              @RequestParam(value = "bookname", required = false) String bookname) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client = clientService.getClientByNickname(name);
        clientWishService.addWishing(authorName, authorSurname, authorMiddlename, bookname, client);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/addhaving", method = RequestMethod.GET)
    public String addHaving(Model model) {
        return "addhaving";
    }

    @RequestMapping(value = "/posthaving", method = RequestMethod.POST)
    public String postHaving(Model model,
                             @RequestParam(value = "author_name", required = false) String authorName,
                             @RequestParam(value = "author_surname", required = false) String authorSurname,
                             @RequestParam(value = "author_middlename", required = false) String authorMiddlename,
                             @RequestParam(value = "pubhouse", required = false) String pubhouse,
                             @RequestParam(value = "pub_year", required = false) String pubyear,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam(value = "bookname", required = false) String bookname) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client = clientService.getClientByNickname(name);
        clientHavingService.addClientHaving(client, authorName, authorSurname, authorMiddlename, pubhouse, pubyear, description, bookname);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String getConnectPage(Model model,
                                 @RequestParam(value = "id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client1 = clientService.getClientByNickname(name);
        List<Book> having = clientHavingService.getAllBooksThatClientHas(client1);
        Client client2 = clientService.getClientById(id);
        List<Book> wishing = clientHavingService.getAllBooksThatClientHas(client2);

        model.addAttribute("havingBooks", having);
        model.addAttribute("wishingBooks", wishing);
        model.addAttribute("receiver", client2);
        return "connect";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String sendOffer(Model model,
                            @RequestParam(value = "id") Integer id,
                            @RequestParam(value = "have") Integer have,
                            @RequestParam(value = "wish") Integer wish) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client1 = clientService.getClientByNickname(name);

        Client client2 = clientService.getClientById(id);

        Book havingBook = bookService.getById(have);
        Book wishBook = bookService.getById(wish);

        messageService.addNewMessage(client1, client2, havingBook, wishBook);

        model.addAttribute("success", "Ваше предложение успешно отправлено.");
        return "success";
    }

    @RequestMapping(value = "/deleteHaving", method = RequestMethod.POST)
    public String deleteHaving(Model model,
                            @RequestParam(value = "id") Integer id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client = clientService.getClientByNickname(name);

        Book book = bookService.getById(id);

        clientHavingService.deleteClientHaving(client, book);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/deleteWish", method = RequestMethod.POST)
    public String deleteWish(Model model,
                               @RequestParam(value = "id") Integer id) {

        clientWishService.deleteById(id);

        return "redirect:/profile";
    }


    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    public String deleteMessage(Model model,
                             @RequestParam(value = "id") Integer id) {

        messageService.deleteById(id);

        return "redirect:/client/requests";
    }

}
