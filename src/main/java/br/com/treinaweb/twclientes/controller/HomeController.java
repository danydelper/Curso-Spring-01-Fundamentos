package br.com.treinaweb.twclientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("boasVindas", "Bem vindo ao Curso de Spring com Thymeleaf");

        List<String> aulas = new ArrayList<>();
        aulas.add("Aula 01 - Introdução");
        aulas.add("Aula 02 - Template engines");
        aulas.add("Aula 03 - Arquivos Estáticos");

        model.addAttribute("aulas", aulas);

        return "home";
    }

/*
-->funciona os dois modos por ModelMap ou ModelView
    @GetMapping("/mensagem")
    public String mensagem(ModelMap modelMap) {
        modelMap.addAttribute("mensagem", "Mensagem vinda do servidor");

        return "mensagem";
    }
*/
    @GetMapping("/mensagem")
    public ModelAndView mensagem() {
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("mensagem");
        modelAndView.addObject("mensagem", "Outra mensagem vinda do servidor");
    
        return modelAndView;
    }

/*
-->funciona os dois modos por ModelMap ou ModelView
    @GetMapping("/saudacao/{nome}")
    public ModelAndView saudacao(@PathVariable String nome) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);

        return modelAndView;
        
        //Como passa no browser o nome 
        //->http://localhost:8080/saudacao/Daniel

    }
*/

@GetMapping("/saudacao")
public ModelAndView saudacao(@RequestParam(required = false, defaultValue = "Treinaweb") String nome) {
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("saudacao");
    modelAndView.addObject("nome", nome);

    return modelAndView;
    //Como passa no browser o nome 
    //->http://localhost:8080/saudacao?nome=Daniel
}

}
