import { Component, OnInit } from '@angular/core';
import { ProductownerdetailsService } from '../productownerdetails.service';

@Component({
  selector: 'app-project-owner-profile',
  templateUrl: './project-owner-profile.component.html',
  styleUrls: ['./project-owner-profile.component.scss']
})
export class ProjectOwnerProfileComponent implements OnInit {

  constructor(private productownerdetails: ProductownerdetailsService) { }
  email: String
  profile: any = [];
  role: String;
  ngOnInit() {
    this.role = localStorage.getItem("role");
    this.email = localStorage.getItem("email");
    this.productownerdetails.getDtailsOfProjectOwner(this.email).subscribe(data => {
      this.profile = data;
    });
  }
}
