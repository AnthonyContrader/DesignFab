import{Component, OnInit} from '@angular/core';
import{MachineService} from 'src/service/machineservice';
import{MachineDTO} from 'src/dto/Machinedto';
import { template } from '@angular/core/src/render3';
import { ThrowStmt } from '@angular/compiler';
import { MachineSensorDTO } from 'src/dto/machinesensordto';
import { SensorDTO } from 'src/dto/sensordto';
import { SensorService } from 'src/service/sensor.service';

@Component({
    selector:'app-machines',
    templateUrl: './machine.component.html',
    styleUrls:['./machine.component.css']
})
export class MachineComponent implements OnInit{

        machines: MachineDTO[];
        sensor : SensorDTO[];
        machineToInsert: MachineDTO = new MachineDTO();
        machinesensorDTO : MachineSensorDTO;
        machinesensorToInsert : MachineDTO = new MachineDTO();

        constructor(private machineService: MachineService, private sensorService : SensorService){}

        ngOnInit(){
            this.getMachines();
            this.getSensors();
        }

        getMachines(){
            this.machineService.getAll().subscribe(machines => this.machines = machines);
        }

        getSensors(){
            this.sensorService.getAll().subscribe(sensor => this.sensor = sensor);
        }

        delete(machines : MachineDTO){
            this.machineService.delete(machines.idMachine).subscribe(()=>this.getMachines());
        }

        update(machines :MachineDTO){
            this.machineService.update(machines).subscribe(()=>this.getMachines());
        }

        insert(machines: MachineDTO){
            this.machineService.insert(machines).subscribe(()=>this.getMachines());
        }
        insert2(idSensor: number,machineName: String){
            this.machinesensorDTO= new MachineSensorDTO(machineName, idSensor);
            this.machineService.insert2(this.machinesensorDTO).subscribe(()=>this.getMachines());
            
            console.log("MACHINE NAME: "+machineName +"\t"+" ID SENSORE "+idSensor);
            //this.materialService.read(idMaterial).subscribe(m=> this.m = m);
            //this.sensorService.insert2(idMaterial, sensor_name).subscribe(()=>this.getSensor());
            
            
          }

        clear(){
            this.machineToInsert = new MachineDTO();
        }
}