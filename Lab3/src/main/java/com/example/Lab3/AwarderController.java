package com.example.Lab3;

import com.example.Lab3.Entity.Awarder;
import com.example.Lab3.repos.AwarderRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AwarderController {
    @Autowired
    private AwarderRepos awarderRepos;
    @RequestMapping("/awarder")
    public String awarder(
            @RequestParam(name = "name", required = false, defaultValue = "Ilya") String name,
            Model model) {
        //model.addAttribute("name", name);
        var awarders = awarderRepos.findAll();
        model.addAttribute("awarders", awarders);
        return "awarder";
    }

    @RequestMapping(value = "/awarder/addAwarder", method = RequestMethod.GET)
    public String addAwarder(
            Model model) {
        model.addAttribute("awarder", new Awarder());
        //var awarders = awarderRepos.findAll();
        return "add-awarder";
    }

    @RequestMapping(value = "/awarder/addAwarder", method = RequestMethod.POST)
    public String addAwarderSubmit(@ModelAttribute Awarder awarder,
            Model model) {
        awarderRepos.save(awarder);
        return "redirect:/awarder";
    }

    @RequestMapping(value = "/awarder/editAwarder/{id}", method = RequestMethod.GET)
    public String editAwarder(@PathVariable(value = "id") Long id,
            Model model) {
        Awarder awarder = awarderRepos.findById(id).get();
        model.addAttribute("awarder", awarder);
        //var awarders = awarderRepos.findAll();
        return "edit-awarder";
    }

    @RequestMapping(value = "/awarder/editAwarder", method = RequestMethod.POST)
    public String editAwarderSubmit(@ModelAttribute Awarder awarder,
                                   Model model) {
        var item = awarderRepos.findById((long) awarder.getId()).get();
        item = awarder;
        awarderRepos.save(item);
        return "redirect:/awarder";
    }
}
