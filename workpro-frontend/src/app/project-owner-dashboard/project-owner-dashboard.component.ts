import { Component, OnInit } from '@angular/core';
import { FreelancerDetailsService } from '../freelancer-details.service';
import { RecommendationService } from '../recommendation.service';

@Component({
  selector: 'app-project-owner-dashboard',
  templateUrl: './project-owner-dashboard.component.html',
  styleUrls: ['./project-owner-dashboard.component.scss']
})
export class ProjectOwnerDashboardComponent implements OnInit {

  constructor(private freelancerService: FreelancerDetailsService, private recommendation: RecommendationService) { }
  freelancers;
  recommendedFreelancers: any
  freelancerArray: any = []
  isSearch: boolean = true
  message=false

  ngOnInit() {

    this.recommendation.getAllFreelancerRecommendation("Angular,Java").subscribe(data => {
      this.recommendedFreelancers = data
      for (let i in this.recommendedFreelancers) {
        let p = this.recommendedFreelancers[i].f
        let propertyList = p.propertyList
        this.freelancerService.getDetailsOfFreelancers(propertyList[0].value).subscribe(data => {
          this.freelancerArray.push(data)
        })
      }
    });
  }
  searchFreelancer(skill) {
    this.isSearch = false
    this.freelancerService.getSearchResults(skill).subscribe((data: any) => {
      this.freelancers = data.list;
      if(this.freelancers===null){
        this.message=true
      }
    })
  }
}
