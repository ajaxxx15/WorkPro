import { Component, OnInit, Input } from '@angular/core';
import { FreelancerserviceService } from '../freelancerservice.service';
import { ProductownerdetailsService } from '../productownerdetails.service';
@Component({
  selector: 'app-project-card-user-dashboard',
  templateUrl: './project-card-user-dashboard.component.html',
  styleUrls: ['./project-card-user-dashboard.component.scss']
})
export class ProjectCardUserDashboardComponent implements OnInit {

  @Input() project;

  constructor(private search: ProductownerdetailsService) { }
  arraySearch: any = [];
  ngOnInit() {

  }
}
