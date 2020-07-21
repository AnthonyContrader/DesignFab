import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { MachineDTO } from 'src/dto/Machinedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class MachineService extends AbstractService<MachineDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type='machines';
    }
}