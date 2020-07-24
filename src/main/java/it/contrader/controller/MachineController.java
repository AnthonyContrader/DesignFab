package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.MachineConverter;
import it.contrader.converter.SensorConverter;
import it.contrader.dto.MachineDTO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Materials;
import it.contrader.service.MachineService;
import it.contrader.service.SensorService;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "http://localhost:4200")
public class MachineController  extends AbstractController<MachineDTO>{


}
