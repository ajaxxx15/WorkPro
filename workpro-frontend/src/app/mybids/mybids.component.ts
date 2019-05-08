import { Component, OnInit, Input } from '@angular/core';
import { FreelancerDetailsService } from '../freelancer-details.service';
import { LoginAuthService } from '../login-auth.service';

@Component({
  selector: 'app-mybids',
  templateUrl: './mybids.component.html',
  styleUrls: ['./mybids.component.scss']
})
export class MybidsComponent implements OnInit {
  decodeToken: any;
  projects1: any = [];
  projects = [];
  email: String;
  wonProjects: any = []
  constructor(private freelancerdetails: FreelancerDetailsService, private loginauth: LoginAuthService) { }
  @Input()
  ngOnInit() {
    this.email = localStorage.getItem("email");
    this.freelancerdetails.getBidsofFreelancer(this.email).subscribe(data => {
      this.projects1 = data;
      this.projects = this.projects1;
    });
    this.freelancerdetails.getAwardedBids(this.email).subscribe(data => {
      this.wonProjects = data;
    });

  }


  filterOpenBids() {
    this.projects = this.projects1.filter(e => {
      if (e.status === "open") {
        return e;
      }
    });
  }
  filterCloseBids() {
    this.projects = this.projects1.filter(e => {
      if (e.status === "close") {
        return e;
      }
    });
  }
  filterWonBids() {
    this.projects = this.wonProjects

  }

}