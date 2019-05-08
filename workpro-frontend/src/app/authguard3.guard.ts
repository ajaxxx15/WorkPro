import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Authguard3Guard implements CanActivate {

  constructor(private route: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    if (localStorage.getItem('token')) {
      if (localStorage.getItem('role') === 'USER') {
        this.route.navigateByUrl('/userdashboard')
        return false
      }
      this.route.navigateByUrl('/podashboard')
      return false
    }
    return true
  }

}
