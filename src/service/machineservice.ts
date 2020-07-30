import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { MachineDTO } from 'src/dto/Machinedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MachineSensorDTO } from 'src/dto/machinesensordto';


@Injectable({
    providedIn: 'root'
})

export class MachineService extends AbstractService<MachineDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type='machines';
    }

    insert2(machinesensorDTO: MachineSensorDTO): Observable<MachineDTO> {
        return this.http.post<any>('http://localhost:8080/' + this.type + '/insert2', machinesensorDTO);
      }

      update2(machinesensorDTO: MachineSensorDTO): Observable<MachineDTO> {
        return this.http.put<any>('http://localhost:8080/' + this.type + '/update2', machinesensorDTO);
      }
}