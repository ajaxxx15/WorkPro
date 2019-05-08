import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { FreelancerDetailsService } from './freelancer-details.service';
import { ProductownerdetailsService } from './productownerdetails.service';
@Injectable()
export class AuthGuard implements CanActivate {

    projectowner: any;
    user: any;

    constructor(private router: Router, private freelancerDetailsService: FreelancerDetailsService, private productownerdetailsService: ProductownerdetailsService) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

        if (localStorage.getItem('role') === 'USER') {
            this.freelancerDetailsService.getDetailsOfFreelancers(localStorage.getItem('email')).subscribe(data => {
                this.user = data;
                console.log(this.user.freelancerEmail);
                if (this.user.freelancerEmail === null) {
                    this.router.navigateByUrl('/editfreelancerprofile');
                    return false;
                }
            });
            return true;

        }
        else if (localStorage.getItem('role') === 'ADMIN') {
            this.productownerdetailsService.getDtailsOfProjectOwner(localStorage.getItem('email')).subscribe(data => {
                this.projectowner = data;
                if (this.projectowner.email === null) {
                    this.router.navigate(['/editpoprofile']);
                    return false;
                }

            });
            return true;

        }

        this.router.navigate(['/login']);
        return false;


    }
}