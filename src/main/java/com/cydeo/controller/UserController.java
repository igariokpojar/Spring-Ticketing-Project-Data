package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create") // localhost:8080 -> retrieve the form by @GetMapping
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("users", userService.listAllUsers());

        return "/user/create";

    }
   // @Valid -> add this validation on the end of the project here in front of @Validation@ModelAttribute
    @PostMapping("/create") // this method is going to post
    public String insertUser(      @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("roles", roleService.listAllRoles());// look in the UserService
            model.addAttribute("users", userService.listAllUsers());// look in the UserService

            return "/user/create";

        }

        userService.save(user);

        return "redirect:/user/create";

    }
    //  when ever I click on Update button I don't want to see any empty Object, I want to see Object populating what ever is chosen
    @GetMapping("/update/{username}") // edit user
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findByUserName(username)); // from Service
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("users", userService.listAllUsers());

        return "/user/update";

    }
    //@Valid
    // when ever we Save the Updates Object this Update User method will execute(is going to post Update User in the UserList)
    // go to UserService Interface and write the UPDATE method
    @PostMapping("/update")
    public String updateUser(      @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("roles", roleService.listAllRoles());
            model.addAttribute("users", userService.listAllUsers());

            return "/user/update";

        }

        userService.update(user);

        return "redirect:/user/create";

    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.delete(username);
        return "redirect:/user/create";
    }


}
