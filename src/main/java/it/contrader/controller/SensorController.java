package it.contrader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SensorDTO;


@RestController
@RequestMapping("/sensor")
@CrossOrigin(origins = "http://localhost:4200")
public class SensorController extends AbstractController<SensorDTO>{



}
