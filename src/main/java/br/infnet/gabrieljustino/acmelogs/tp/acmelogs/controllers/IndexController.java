package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String inserir() {
        return "redirect:/usuario/registrar";
    }
}
