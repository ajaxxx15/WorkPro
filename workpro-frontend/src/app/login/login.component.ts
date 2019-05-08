import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { LoginAuthService } from '../login-auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {



  public user: any = {};
  decodedToken: any;
  role: any
  email: any
  obj1: any;
  constructor(private userService: UserserviceService, private router: Router, private authService: LoginAuthService) {
    this.authService.isLoggedIn();
  }
  ngOnInit() {

  }

  loginUser(user: any) {
    this.userService.loginUser(user).subscribe((response) => {
      if (response) {
        localStorage.setItem('token', JSON.stringify(response.token));

        this.decodedToken = this.authService.checkToken();
        if (this.decodedToken) {
          this.role = this.decodedToken.role;
          this.email = this.decodedToken.sub;
          localStorage.setItem("email", this.email);
          localStorage.setItem("role", this.role);
          this.obj1 = {
            "status": true,
            "role": localStorage.getItem('role')
          };
        }

        if (localStorage.getItem("role") === 'USER') {
          this.router.navigateByUrl('/userdashboard');

          this.authService.loggedIn.next(this.obj1)


        }
        else {
          this.router.navigateByUrl('/podashboard');
          this.authService.loggedIn.next(this.obj1)
        }
      }
    })

  }
}
