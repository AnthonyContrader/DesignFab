import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from './user-routing.module';
import { FormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

@NgModule({
  declarations: [UserDashboardComponent],
  imports: [
    CommonModule, 
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
