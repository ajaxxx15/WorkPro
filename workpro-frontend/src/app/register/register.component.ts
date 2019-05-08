import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  public user: any = {};
  constructor(private userservice: UserserviceService, private router: Router) { } ngOnInit() {
  }
  saveUser(user: any, userForm: any) {
    user.enable = true;
    this.userservice.saveUser(user).subscribe((response) => {
      if (response) {
        this.router.navigate(['/login']);
      }
    })
  }
}

