package springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springmvc.dao.UserDAOImpl;
import springmvc.models.User;
import springmvc.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService  userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "users/show";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
