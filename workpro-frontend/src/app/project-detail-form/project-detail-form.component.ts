import { Component, OnInit } from '@angular/core';
import { ProductownerdetailsService } from '../productownerdetails.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-project-detail-form',
  templateUrl: './project-detail-form.component.html',
  styleUrls: ['./project-detail-form.component.scss']
})
export class ProjectDetailFormComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  public user: any = {};
  skills = [];
  bid = [];
  addBidToProjects = false;
  constructor(private _formBuilder: FormBuilder, private productownerdetailsService: ProductownerdetailsService, private route: Router) { }
  email: String;


  ngOnInit() {
    this.email = localStorage.getItem("email");
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }
  saveUser(user: any, userForm: any) {
    user.skillsSetList = this.skills;
    user.projectName = user.projectName;
    user.projectStatus = "open";
    user.allBidsOfFreelancers = [];
    user.projectDescription = user.projectDescription;
    user.projectCompletionDate = user.projectCompletionDate;
    user.projectPreference = user.projectPreference;
    user.projectLocation = user.projectLocation;
    user.projectOwnerEmailId = this.email;
    user.bidSpecsProvidedByProjectOwners = this.bid;


    let project = {
      projectOwnerEmailId: this.email,
      projectDetailsList: [user],
    }

    this.productownerdetailsService.setProjectDetails(project).subscribe(data => {
      this.route.navigate(['productownermyprojects']);
    });
  }

  addSkill(skill) {
    this.skills.push(skill)
  }

  addBid(bid) {
    let bidDetails =
    {
      bidLastDate: bid.bidLastDate,
      maximumBudget: bid.maximumBudget,
      minimumBudget: bid.minimumBudget,

    }
    this.addBidToProjects = true;
    this.bid.push(bidDetails)
  }
  deleteSkill(skill) {
    this.skills = this.skills.filter(e => e.skillName !== skill.skillName)
  }

  removeSkill(skill) {
    this.skills = this.skills.filter(e => {
      return e !== skill
    })
  }
}
