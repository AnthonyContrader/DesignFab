import { Component, OnInit } from '@angular/core';
import { MaterialsDTO } from 'src/dto/materialsdto';
import { MaterialService } from 'src/service/material.service';
import { Materialtype } from 'src/dto/Materialtype';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-2machine.component.html',
  styleUrls: ['./user-2machine.component.css']
})

export class User2MachineComponent implements OnInit {

  provaMaterials : MaterialsDTO;
  materials: MaterialsDTO[];
  materialtype = [];
  enum = Materialtype;


    constructor(private service: MaterialService) { 
      this.getMaterials();
     
      this.materialtype = Object.keys(this.enum).filter(f => isNaN(Number(f)));
    }

    ngOnInit() {
      this.provaMaterials = JSON.parse(localStorage.getItem('prova'));
    }

    getMaterials() {
      this.service.getAll().subscribe(materials => this.materials = materials);
    }

    read(idMaterial : number) {
      this.service.read(idMaterial).subscribe(materials => this.provaMaterials = materials);
    }

    update(material: MaterialsDTO) {
    
      this.provaMaterials.materialsQuantity = material.materialsQuantity/3;
      this.service.update(this.provaMaterials).subscribe(() => this.read(this.provaMaterials.idMaterial));
    }
    
}