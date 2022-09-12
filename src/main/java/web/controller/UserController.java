package web.controller;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

import javax.validation.Valid;
@Controller
@RequestMapping("/people")
public class UserController {
    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", us.index());
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", us.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            us.save(user);
            return "redirect:/people";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", us.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            us.update(user);
            return "redirect:/people";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        us.delete(id);
        return "redirect:/people";
    }
}
