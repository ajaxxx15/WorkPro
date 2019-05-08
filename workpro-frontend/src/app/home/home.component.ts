import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ViewProfileDailogComponent } from '../view-profile-dailog/view-profile-dailog.component';
import { Router } from '@angular/router';
import { RecommendationService } from '../recommendation.service';
import { FreelancerDetailsService } from '../freelancer-details.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  recommendedFreelancers:any=[]
  freelancerArray:any=[]
  projectsArray:any=[]
  recommendedProjects
  constructor(public dialog: MatDialog, private router: Router,private recommendation:RecommendationService,private freelancerService:FreelancerDetailsService ) { }

  ngOnInit() {

    this.recommendation.getAllFreelancerRecommendation("Angular,Java").subscribe(data => {
      this.recommendedFreelancers = data
      var j=0;
      for (let i in this.recommendedFreelancers) {
       if(j<=3){
        let p = this.recommendedFreelancers[i].f
        let propertyList = p.propertyList
        this.freelancerService.getDetailsOfFreelancers(propertyList[0].value).subscribe(data => {
          this.freelancerArray.push(data)          
        })
        j++;
      }
     
    }
      console.log(this.freelancerArray,"final")
    });


    this.recommendation.getAllProjectRecommendation("Angular,Java").subscribe(data => {
      this.recommendedProjects = data
      console.log(this.recommendedProjects,"all")
      var j=0
      for (let i in this.recommendedProjects) {
        if(j<=3){
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
        j++;
      }
    }
    })
    console.log(this.projectsArray,"projects")
  }

  openDialog(value,value2) {
    const dialogRef = this.dialog.open(ViewProfileDailogComponent,{
      data: { name: value,skill:value2}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
    console.log("this is happening ??")
  }

  searchProject(value) {
    this.router.navigateByUrl(`/search/${value}`);
  }
  
}
