import { Component, OnInit } from '@angular/core';
import { SensorService } from 'src/service/sensor.service';
import { SensorDTO } from 'src/dto/sensordto';
import { template } from '@angular/core/src/render3';
import { ThrowStmt } from '@angular/compiler';
import { MaterialsDTO } from 'src/dto/materialsdto';
import { MaterialService } from 'src/service/material.service';
import { Materialtype } from 'src/dto/Materialtype';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.css']
})
export class SensorComponent implements OnInit {

  sensor: SensorDTO[];
  sensorToInsert: SensorDTO = new SensorDTO();
  materials: MaterialsDTO[];
  materialsensorToInsert: MaterialsDTO= new MaterialsDTO();
  materialtype = [];
  enum = Materialtype;
 

  constructor(private sensorService: SensorService, private materialService: MaterialService) {
    this.materialtype = Object.keys(this.enum).filter(f => isNaN(Number(f)));
  }

  ngOnInit() {
    this.getSensor();
    this.getMaterial()
    
  }
  getMaterial(){
 this.materialService.getAll().subscribe(materials=> this.materials = materials);
  }

  getSensor(){
    this.sensorService.getAll().subscribe(sensor=> this.sensor = sensor);
  }

  delete(sensor : SensorDTO){
    this.sensorService.delete(sensor.idSensor).subscribe(()=>this.getSensor());
  }

  update(sensor :SensorDTO){
    this.sensorService.update(sensor).subscribe(()=>this.getSensor());
  }

  insert(sensor: SensorDTO){
    this.sensorService.insert(sensor).subscribe(()=>this.getSensor());
  
  }

  clear(){
    this.sensorToInsert = new SensorDTO();
  }

}
