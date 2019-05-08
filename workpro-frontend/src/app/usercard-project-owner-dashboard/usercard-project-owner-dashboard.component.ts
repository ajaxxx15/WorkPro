import { Component, OnInit, Input } from '@angular/core';
import { FreelancerDetailsService } from '../freelancer-details.service';
import { FreelancerserviceService } from '../freelancerservice.service';


@Component({
  selector: 'app-usercard-project-owner-dashboard',
  templateUrl: './usercard-project-owner-dashboard.component.html',
  styleUrls: ['./usercard-project-owner-dashboard.component.scss']
})
export class UsercardProjectOwnerDashboardComponent implements OnInit {
  @Input() freelancer;
  constructor(private search: FreelancerserviceService) { }
  arraySearch: any = [];
  ngOnInit() {

  }

}
