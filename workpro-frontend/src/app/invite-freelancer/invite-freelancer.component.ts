import { Component, OnInit } from '@angular/core';
import { ProductownerdetailsService } from '../productownerdetails.service';
import { ActivatedRoute } from '@angular/router';
import { FreelancerDetailsService } from '../freelancer-details.service';

@Component({
  selector: 'app-invite-freelancer',
  templateUrl: './invite-freelancer.component.html',
  styleUrls: ['./invite-freelancer.component.scss']
})
export class InviteFreelancerComponent implements OnInit {

  id: String;
  projects1: any
  projects: any = []
  constructor(private productownerdetailsService: ProductownerdetailsService, private route: ActivatedRoute, private freelancerdetaisservice: FreelancerDetailsService) { }

  ngOnInit() {

    this.productownerdetailsService.getProjectDetails(localStorage.getItem('email')).subscribe(data => {
      this.projects1 = data
      this.projects = this.projects1["projectDetailsList"].filter(e => {
        if (e.projectStatus === "open") {
          return e;
        }
      });
    });
  }

  sendEmail(value) {
    this.route.params.subscribe(data => {
      this.id = data.id;

      console.log(this.id)
    
      let email = {
        "to": this.id,
        "subject": null,
       "body":null
      }
      this.freelancerdetaisservice.inviteFreelancer(value,localStorage.getItem('email'),email).subscribe(console.log)
    })
  }
}
