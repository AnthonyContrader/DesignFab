import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { MaterialsDTO } from 'src/dto/materialsdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
    providedIn: 'root'
  })
  export class MaterialService extends AbstractService<MaterialsDTO>{


    constructor(http: HttpClient) {
        super(http);
        this.type = 'materials';
      }
    }