package com.sda.travelAgency.controller.continent;

import com.sda.travelAgency.dto.continent.ContinentFullDto;
import com.sda.travelAgency.model.LoginForm;
import com.sda.travelAgency.service.impl.continent.ContinentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ContinentControllerThymeleaf {

    private final ContinentService continentService;

    @Value("$(th.login.username")
    private String userName;

    @Value("$(th.login.password")
    private String userPassword;

    public ContinentControllerThymeleaf(ContinentService continentService) {
        this.continentService = continentService;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "start";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLoginForm(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
            return "home";
        }
        model.addAttribute("invalid credentials", true);
        return "start";
    }

    @RequestMapping(value = "showAll", method = RequestMethod.GET)
    public String showAllContinents(Model model) {
        List<ContinentFullDto> continentList = continentService.findAllContinents();
        model.addAttribute("continentsList", continentList);
        return "continentTable";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
