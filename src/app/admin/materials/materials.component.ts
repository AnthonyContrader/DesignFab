import { Component, OnInit } from '@angular/core';
import { MaterialService } from 'src/service/material.service';
import { MaterialsDTO } from 'src/dto/materialsdto';

@Component({
  selector: 'app-materials',
  templateUrl: './materials.component.html',
  styleUrls: ['./materials.component.css']
})
export class MaterialComponent implements OnInit {

  materials: MaterialsDTO[];
  materialstoinsert: MaterialsDTO = new MaterialsDTO();

  constructor(private service: MaterialService) { }

  ngOnInit() {
    this.getMaterials()
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
