import { Component, OnInit, Inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FreelancerDetailsService } from '../freelancer-details.service';
import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-bidview',
  templateUrl: './bidview.component.html',
  styleUrls: ['./bidview.component.scss']
})
export class BidviewComponent implements OnInit {

  pid: String;
  poemail: String;
  constructor(private freelancerDetailsService: FreelancerDetailsService, private route: ActivatedRoute, @Inject(MAT_DIALOG_DATA) public data: any, private router: Router) { }

  ngOnInit() {
  }

  savebid(user) {
    let bidinfo = {
      "projectId": this.data.pid,
      "projectName": this.data.pname,
      "projectOwnerEmail": this.data.poemail,

      "freelancerEmail": this.data.freelanceremail,
      "duration": user.duration,
      "bidAmount": +user.amount,
      "projectAwarded": false,
      "status": "open"
    }
    this.freelancerDetailsService.postBids(bidinfo).subscribe(data=>{
      console.log(data)
      this.router.navigate(['mybids']);
    });
  }
}
