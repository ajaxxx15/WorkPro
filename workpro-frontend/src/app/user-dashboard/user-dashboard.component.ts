import { Component, OnInit } from '@angular/core';
import { FreelancerserviceService } from "../freelancerservice.service";
import { ProductownerdetailsService } from '../productownerdetails.service';
import { RecommendationService } from '../recommendation.service';
import { FreelancerDetailsService } from '../freelancer-details.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss']
})
export class UserDashboardComponent implements OnInit {

  constructor(private projectService: ProductownerdetailsService, private recommendation: RecommendationService, private freelancerdetails: FreelancerDetailsService) { }
  projects;
  skill: any;
  recommendedProjects: any = [];
  profile: any = [];
  isSearch: boolean = true
  projectsArray: any = []
  message=false


  ngOnInit() {
    var skills = new String();
    this.freelancerdetails.getDetailsOfFreelancers(localStorage.getItem('email')).subscribe(data => {
      this.profile = data;
      this.skill = this.profile.skills;
      let lastindex = this.skill.length;

      for (var i of this.skill) {
        let indexof = this.skill.lastIndexOf(i)
        if (indexof === lastindex - 1) {
          skills = skills.concat(i)
        }
        else {
          skills = skills.concat(i + ",")
        }


      }
      this.recommendation.getAllProjectRecommendation(skills).subscribe(data => {
        this.recommendedProjects = data
        for (let i in this.recommendedProjects) {
          let p = this.recommendedProjects[i].p
          console.log(p)
          let propertyList = p.propertyList
          let Projects1 = {
            "projectOwnerEmailId": propertyList[0].value,
            "projectDescription": propertyList[1].value,
            "ProjectId": propertyList[2].value,
            "projectName":propertyList[3].value

          }
          this.projectsArray.push(Projects1)
        }
      })
    });

  }
  searchProject(skill) {
    this.isSearch = false;
    this.projectService.getResults(skill).subscribe((data: any) => {
      this.projects = data;
      if(this.projects===null){
        this.message=true;
      }
    });
  }
}
