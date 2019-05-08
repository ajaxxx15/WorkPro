import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-view-profile-dailog',
  templateUrl: './view-profile-dailog.component.html',
  styleUrls: ['./view-profile-dailog.component.scss']
})
export class ViewProfileDailogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  name:String
  skills:any
  ngOnInit() {
    this.name=this.data.name;
    this.skills=this.data.skill;
    console.log(this.skills)
    
  }

  freelancers = [
    {
      "name": "Arline Skinner",
      "email": "arlineskinner@pharmex.com",
      "skills": " Android / Java / Mobile App Development",
      "profilePicUrl": "../assets/images/dummy-user.png"
    },
    {
      "name": "Cristina Bernard",
      "email": "cristinabernard@pharmex.com",
      "skills": " Android / jQuery / Prototype / Mobile App Development / PhoneGap / Technical Support ",
      "profilePicUrl": "../assets/images/dummy-user.png"
    },
    {
      "name": "Sadie Olson",
      "email": "sadieolson@pharmex.com",
      "skills": " Android / Java / Mobile App Development / MySQL / PHP ",
      "profilePicUrl": "../assets/images/dummy-user.png"
    },
    {
      "name": "Eileen Harris",
      "email": "eileenharris@pharmex.com",
      "skills": " Android / iPhone / Mobile App Development / Objective C / Swift",
      "profilePicUrl": "../assets/images/dummy-user.png"
    },
    {
      "name": "Garza Terrell",
      "email": "garzaterrell@pharmex.com",
      "skills": " Android / Ionic Framework / iOS Development / iPhone node.js ",
      "profilePicUrl": "../assets/images/dummy-user.png"
    }
  ]
}
