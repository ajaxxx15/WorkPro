import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard1Guard implements CanActivate {

  projectowner: any;
  user: any;

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    if (localStorage.getItem('token')) {
      if (localStorage.getItem('role') === 'ADMIN') {
        return true;
      }
      else {
        this.router.navigate(['/userdashboard'])
        return false;
      }

    }

    this.router.navigate(['/login']);
    return false;
  }

}
