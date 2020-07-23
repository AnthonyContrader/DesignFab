import { Component, OnInit } from '@angular/core';
import { SensorService } from 'src/service/sensor.service';
import { SensorDTO } from 'src/dto/sensordto';
import { template } from '@angular/core/src/render3';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.css']
})
export class SensorComponent implements OnInit {

  sensor: SensorDTO[];
  sensorToInsert: SensorDTO = new SensorDTO();

  constructor(private sensorService: SensorService) {}

  ngOnInit() {
    this.getSensor()
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
