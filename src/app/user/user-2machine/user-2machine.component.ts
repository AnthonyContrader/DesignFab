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

  provaMaterials : number;
  materialToUpdate : MaterialsDTO= new MaterialsDTO;
  materials: MaterialsDTO[];
  materialtype = [];
  enum = Materialtype;
  quantity : number;
  public show:boolean = false;
  public buttonName:any = 'Show';


    constructor(private service: MaterialService) { 
      this.getMaterials();
      this.materialtype = Object.keys(this.enum).filter(f => isNaN(Number(f)));
    }

    ngOnInit() {
      this.provaMaterials = JSON.parse(localStorage.getItem('prova'));
    }
    toggle() {
      this.show = !this.show;
  
      // CHANGE THE NAME OF THE BUTTON.
      if(this.show)  
        this.buttonName = "Hide";
      else
        this.buttonName = "Show";
    }

    getMaterials() {
      this.service.getAll().subscribe(materials => this.materials = materials);
    }

    read(idMaterial : number) {
      console.log(idMaterial);
      this.service.read(idMaterial).subscribe(material => this.materialToUpdate = material);
      console.log(this.materialToUpdate);
     }

    update(material: MaterialsDTO) {
      this.quantity = material.materialsQuantity/3;
      material.materialsQuantity=this.quantity;
      this.service.update(material).subscribe(() => this.getMaterials());
    }
    
}