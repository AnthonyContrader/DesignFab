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
        this.type='sensor';
    }

    insert2(idMaterial: number,sensor_name: String): Observable<any> {
        return this.http.get<any>('http://localhost:8080/' + this.type + '/insert2/' + idMaterial + sensor_name);
      }
}


