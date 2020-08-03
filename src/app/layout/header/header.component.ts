import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: UserDTO = new UserDTO;
  constructor(private router: Router) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

}
