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
  materials2: MaterialsDTO[];
  materials3: MaterialsDTO[];
  material2: MaterialsDTO = new MaterialsDTO();
  

  constructor(private service: MaterialService,  private router: Router) { }

  ngOnInit() {
    this.getMaterials();
    this.getMaterials3();
         
  }
  getMaterials3() {
    this.service.getAllBy('GENERIC').subscribe(materials3 => this.materials3 = materials3);
  }


  getMaterials() {
    this.service.getAllBy('GENERIC').subscribe(materials => this.materials = materials);
  }

  getMaterials2() {
    this.service.getAll().subscribe(materials => this.materials2 = materials);
  }

  calcola(materialsQuantity: number){
    this.service.calcola(materialsQuantity).subscribe(() => { 
      this.router.navigate(['/user-dashboard/user-2machine']),
      localStorage.setItem('prova', JSON.stringify(materialsQuantity));
     });

  }


  update(updatematerial :MaterialsDTO){
    /*this.service.update(updatematerial).subscribe(() => { 
       this.router.navigate(['/user-dashboard/user-2machine']),
       localStorage.setItem('prova', JSON.stringify(updatematerial));
      }); */
      
  }


}
