import { Component, OnInit } from '@angular/core';
import { ProductownerdetailsService } from '../productownerdetails.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FreelancerDetailsService } from '../freelancer-details.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.scss']
})
export class ProjectDetailsComponent implements OnInit {

  // project:any;
  email: String;
  projects1: any = [];
  role: String;
  isrole: boolean = false;
  isroleAdmin: boolean = false;

  bidsInfromation = [];
  biders = [];
  productid = String;
  id: String;
  constructor(private productownerdetailsService: ProductownerdetailsService, private route: ActivatedRoute, private router: Router,private freelancerdetaisservice:FreelancerDetailsService) {


  }



  ngOnInit() {

    this.route.params.subscribe(data => {
      this.id = data.id;
      this.email = data.email;
    });


    this.role = localStorage.getItem("role");
    // this.email=localStorage.getItem("email");
    if (localStorage.getItem('role')) {
      this.isroleAdmin = true;
      if (this.role === "USER") {
        this.isrole = true;
        this.isroleAdmin = false
      }
    }

    this.productownerdetailsService.getProjectDetailsById(this.email, this.id).subscribe(data => {
      this.projects1 = data;
      this.bidsInfromation = this.projects1["bidSpecsProvidedByProjectOwners"][0];
      this.biders = this.projects1["allBidsOfFreelancers"];
    });


  }

  projectassign(value) {
    let notify = {
      "to": value,
      "subject": null,
     "body":null
    }
    this.productownerdetailsService.awardProject(this.email, this.id, value,notify).subscribe(data=>{
      console.log(data);
      this.router.navigate(['/productownermyprojects']);
    });   
  }

}
