import { Component, OnInit } from '@angular/core';
import { FreelancerDetailsService } from '../freelancer-details.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Profile } from 'selenium-webdriver/firefox';

@Component({
  selector: 'app-freelancerprofile',
  templateUrl: './freelancerprofile.component.html',
  styleUrls: ['./freelancerprofile.component.scss']
})
export class FreelancerprofileComponent implements OnInit {

  constructor(private freelancerdetails: FreelancerDetailsService, private route: ActivatedRoute) { }

  email: String
  profile: any = [];
  role: String;
  id: String;
  isFreelancer: boolean = false
  ngOnInit() {
    this.route.params.subscribe(data => {
      this.id = data.email;
    })
    this.role = localStorage.getItem("role");
    this.email = localStorage.getItem("email");
    if (this.role === 'USER') {
      this.isFreelancer = true;
      this.freelancerdetails.getDetailsOfFreelancers(this.email).subscribe(data => {
        this.profile = data;
        console.log(this.profile)

      });
    }
    else
      this.freelancerdetails.getDetailsOfFreelancers(this.id).subscribe(data => {
        this.profile = data;
      });
  }
}
