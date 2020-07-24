import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { MaterialsDTO } from 'src/dto/materialsdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Materialtype } from 'src/dto/Materialtype';




@Injectable({
    providedIn: 'root'
  })
  export class MaterialService extends AbstractService<MaterialsDTO>{


    constructor(http: HttpClient) {
        super(http);
        this.type = 'materials';
      }

      


  getAllBy(materialType: string): Observable<MaterialsDTO[]> {
    return this.http.get<any>('http://localhost:8080/' + this.type + '/getallby/' + materialType);
  }

    }