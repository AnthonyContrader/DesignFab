import { Component, OnInit } from '@angular/core';
import { MaterialService } from 'src/service/material.service';
import { MaterialsDTO } from 'src/dto/materialsdto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  materials: MaterialsDTO[];
  materialstoinsert: MaterialsDTO = new MaterialsDTO();

  constructor(private service: MaterialService,  private router: Router) { }

  ngOnInit() {
    this.getMaterials();
  }
  getMaterials() {
    this.service.getAllBy('GENERIC').subscribe(materials => this.materials = materials);
  }


  update(updatematerial :MaterialsDTO){
    this.service.update(updatematerial).subscribe(() => { 
       this.router.navigate(['/user-dashboard/user-2machine']),
       localStorage.setItem('prova', JSON.stringify(updatematerial));
      
      
      });   
  }


}
