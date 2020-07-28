
import { MachineDTO } from './../../../dto/Machinedto';

import { Component, OnInit } from '@angular/core';
import { SensorService } from 'src/service/sensor.service';
import { SensorDTO } from 'src/dto/sensordto';
import { template } from '@angular/core/src/render3';
import { ThrowStmt } from '@angular/compiler';
import { MaterialsDTO } from 'src/dto/materialsdto';
import { MaterialService } from 'src/service/material.service';
import { Materialtype } from 'src/dto/Materialtype';
import { NgForm } from '@angular/forms';
import { NgForOf } from '@angular/common';
import { Subscriber } from 'rxjs';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.css']
})
export class SensorComponent implements OnInit {

  sensor: SensorDTO[];
  sensorToInsert: SensorDTO = new SensorDTO();
  materials: MaterialsDTO[];
  materialsensorToInsert: MaterialsDTO = new MaterialsDTO;
  materials2: MaterialsDTO[];
  m: MaterialsDTO = new MaterialsDTO;

 

  constructor(private sensorService: SensorService, private materialService: MaterialService) {}

  ngOnInit() {
    this.getSensor();
    this.getMaterial()
    
  }



  getMaterial(){
 this.materialService.getAll().subscribe(materials=> this.materials = materials);
 
  }

  getSensor(){
    this.sensorService.getAll().subscribe(sensor=> this.sensor = sensor);
    console.log(this.sensor);
  }

  delete(sensor : SensorDTO){
    this.sensorService.delete(sensor.idSensor).subscribe(()=>this.getSensor());
  }

  update(sensor :SensorDTO){
    this.sensorService.update(sensor).subscribe(()=>this.getSensor());
  }

  insert2(idMaterial: number,sensor_name: String){
    console.log(idMaterial);
    
    this.sensorService.insert2(idMaterial, sensor_name).subscribe(()=>this.getSensor);
    
    
  }
  insert(sensor: SensorDTO){
    console.log(sensor);
    this.sensorService.insert(sensor).subscribe(()=>this.getSensor());
  }
 
  clear(){
    this.sensorToInsert = new SensorDTO();
  }

}
