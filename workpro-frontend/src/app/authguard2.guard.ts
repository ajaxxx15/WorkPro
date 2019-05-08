import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class Authguard2Guard implements CanActivate {

  constructor(private router: Router) { }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (localStorage.getItem('token')) {
      if (localStorage.getItem('role') === 'USER') {
        return true;
      }
      else {
        this.router.navigate(['/podashboard'])
        return false;
      }
    }
    this.router.navigate(['/login']);
    return false;
  }


}
