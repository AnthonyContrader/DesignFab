import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from './user-routing.module';
import { FormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { User2MachineComponent } from './user-2machine/user-2machine.component';

@NgModule({
  declarations: [UserDashboardComponent, User2MachineComponent],
  imports: [
    CommonModule, 
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
