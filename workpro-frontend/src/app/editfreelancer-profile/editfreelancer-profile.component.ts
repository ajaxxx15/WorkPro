import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FreelancerDetailsService } from '../freelancer-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editfreelancer-profile',
  templateUrl: './editfreelancer-profile.component.html',
  styleUrls: ['./editfreelancer-profile.component.scss']
})
export class EditfreelancerProfileComponent implements OnInit {

  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  addedSkills: any;
  public user: any = {};
  email: String;
  personalDetails: any = [];
  address;
  professionalDetails;
  details: any = [];
  userPresent: boolean = false;

  constructor(private _formBuilder: FormBuilder, private freelancerDetailsService: FreelancerDetailsService, private route: Router) { }


  ngOnInit() {
    this.email = localStorage.getItem("email");
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });

    this.freelancerDetailsService.getDetailsOfFreelancers(this.email).subscribe(data => {
      this.details = data;
      this.addedSkills = this.details.skills

      if (this.details.freelancerName !== null) {
        this.userPresent = true;
      }
    });
  }
  saveUser() {

    let user = {
      "freelancerName": this.personalDetails.Name,
      "freelancerEmail": this.email,
      "freelancerAddress": this.address.address,
      "yearsOfExpertise": 1,
      "skills": this.addedSkills
    }
    this.freelancerDetailsService.getDetailsOfFreelancers(this.email).subscribe(data => {
      this.details = data;
      this.freelancerDetailsService.postFreelancerDetails(user).subscribe(data => {
        this.route.navigate(['freelancerprofile']);
      });
    }, (err) => {
      console.log("this is comming here !!!!! look carefully ")
    });
  }


  addSkill(skill) {
    this.addedSkills = this.addedSkills || [];
    this.addedSkills.push(skill)
  }

  removeSkill(skill) {
    this.addedSkills = this.addedSkills.filter(e => {
      return e !== skill
    })
  }

  addPersonalDetails(value) {
    this.personalDetails = value
  }

  addEditAddress(value) {
    this.address = value;
  }

  addprofessionaldetails(value) {
    this.professionalDetails = this.addedSkills;
  }
}




