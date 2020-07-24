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
  updatematerial : UpdateMaterialDTO;
  constructor(private service: MaterialService) { }

  ngOnInit() {
    this.getMaterials()
  }

  updateMaterial(updatematerial :UpdateMaterialDTO){
    this.service.updateMaterial(updatematerial).subscribe(() => this.getMaterials());
  }

  getMaterials() {
    this.service.getAll().subscribe(materials => this.materials = materials);
  }

  delete(material: MaterialsDTO) {
    this.service.delete(material.idMaterial).subscribe(() => this.getMaterials());
  }

  update(material: MaterialsDTO) {
    this.service.update(material).subscribe(() => this.getMaterials());
  }

  insert(material: MaterialsDTO) {
    this.service.insert(material).subscribe(() => this.getMaterials());
  }

  clear(){
    this.materialstoinsert = new MaterialsDTO();
  }
}
