import { Component, OnInit } from '@angular/core';
import { MaterialsDTO } from 'src/dto/materialsdto';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-2machine.component.html',
  styleUrls: ['./user-2machine.component.css']
})

export class User2MachineComponent implements OnInit {

  provaMaterials : MaterialsDTO;
  
    constructor() { }
    
    ngOnInit() {
      this.provaMaterials = JSON.parse(localStorage.getItem('prova'));
    }
}