import { Injectable } from '@angular/core';
import { AbstractService} from './abstractservice';
import { SensorDTO } from 'src/dto/sensordto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class SensorService extends AbstractService<SensorDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type='machines';
    }
}


