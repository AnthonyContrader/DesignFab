import{Component, OnInit} from '@angular/core';
import{MachineService} from 'src/service/machineservice';
import{MachineDTO} from 'src/dto/Machinedto';
import { template } from '@angular/core/src/render3';
import { ThrowStmt } from '@angular/compiler';

@Component({
    selector:'app-machines',
    templateUrl: './machine.component.html',
    styleUrls:['./machine.component.css']
})
export class MachineComponent implements OnInit{

        machines: MachineDTO[];
        machineToInsert: MachineDTO = new MachineDTO();

        constructor(private machineService: MachineService){}

        ngOnInit(){
            this.getMachines()
        }

        getMachines(){
            this.machineService.getAll().subscribe(machines => this.machines = machines);
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
        clear(){
            this.machineToInsert = new MachineDTO();
        }
}