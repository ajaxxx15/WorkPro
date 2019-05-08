import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductownerdetailsService } from '../productownerdetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-project-owner-profile',
  templateUrl: './edit-project-owner-profile.component.html',
  styleUrls: ['./edit-project-owner-profile.component.scss']
})
export class EditProjectOwnerProfileComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  public user: any = {};
  constructor(private _formBuilder: FormBuilder, private productownerdetailservice: ProductownerdetailsService, private route: Router) { }
  email: String;
  personalDetails;
  address;
  location;


  ngOnInit() {
    this.email = localStorage.getItem("email");
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }

  saveUser(value, user) {
    this.address = value;
    this.location = value

    user.name = this.personalDetails.name,
      user.email = this.email,
      user.address = this.address.address,
      user.location = this.location.location,
      user.number = this.personalDetails.number

    this.productownerdetailservice.postDetailsOfProjectOwner(user).subscribe(data => {
      this.route.navigate(['/poprofile']);
    })

  }
  addPersonalDetails(value) {
    this.personalDetails = value
  }
}



