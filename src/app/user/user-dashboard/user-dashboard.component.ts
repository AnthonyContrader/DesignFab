import { Component, OnInit } from '@angular/core';
import { MaterialService } from 'src/service/material.service';
import { MaterialsDTO } from 'src/dto/materialsdto';
import {UpdateMaterialDTO} from 'src/dto/updatematerialdto';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  materials: MaterialsDTO[];
  materialstoinsert: MaterialsDTO = new MaterialsDTO();

  constructor(private service: MaterialService) { }

  ngOnInit() {
    this.getMaterials()
  }

  getMaterials() {
    this.service.getAll().subscribe(materials => this.materials = materials);
  }
  
  update(material: MaterialsDTO) {
    this.service.update(material).subscribe(() => this.getMaterials());
  }

  updateMaterial(material :MaterialsDTO){
    this.service.updateMaterial(material).subscribe(() => this.getMaterials());
  }

}
