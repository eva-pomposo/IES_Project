package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MovementsController {

    @GetMapping("client/movements")
    public String getMovements( Model model) {
		return "client/movements";
    }    
}